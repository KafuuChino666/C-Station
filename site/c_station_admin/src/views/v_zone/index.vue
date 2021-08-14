<template>
  <div class="app-main">
    <div class="con-flex">
      <div class="cont-left page-height">
        <el-input
          v-model="filterText"
          style="padding-bottom: 15px"
          placeholder="输入关键字进行过滤"
        />
        <el-tree
          :data="zoneList"
          :load="loadNode"
          :props="props"
          lazy
          show-checkbox
          node-key="id"
          @node-click="nodeClick"
          :expand-on-click-node="false"
        >
          <span class="custom-tree-node" slot-scope="{ node, data }">
            <span>{{ node.label }}</span>
            <span>
              <el-button
                v-if="data.parentId === 0"
                type="text"
                size="mini"
                @click.stop="() => append(data)"
              >
                添加
              </el-button>
              <el-button
                type="text"
                size="mini"
                @click.stop="() => update(data)"
              >
                修改
              </el-button>
              <el-button
                type="text"
                size="mini"
                @click.stop="() => remove(node, data)"
              >
                删除
              </el-button>
            </span>
          </span>
        </el-tree>
      </div>
      <div class="cont-right">
        <el-form :disabled="formStatus === 'echo'" :model="zoneForm" status-icon :rules="formVerify" ref="zoneForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="父级" prop="title">
            {{ zoneForm.parentId }}
          </el-form-item>
          <el-form-item label="标题" prop="title">
            <el-input type="text" v-model="zoneForm.title" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="notes">
            <el-input type="textarea" v-model="zoneForm.notes"></el-input>
          </el-form-item>
          <el-form-item label="排序" prop="sort">
            <el-input type="text" v-model="zoneForm.sort" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button :disabled="formStatus === 'echo'" type="primary" @click="submitForm()">{{ this.submitButTxt }}</el-button>
            <el-button :disabled="formStatus === 'echo'" @click="resetForm()">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import zone from '@/api/zone'
import rule from '@/rules/rule'

export default {
  name: 'Zone',
  data() {
    return {
      zoneList: [],
      props: {
        label: 'title',
        children: 'zones',
        isLeaf: 'leaf'
      },
      formStatus: 'echo',
      filterText: '', // 过滤文本
      zoneForm: {
      },
      formVerify: rule.zoneForm,
      submitButTxt: '提交'
    }
  },
  methods: {
    loadNode(node, resolve) {
      // 加载父节点
      if (node.level === 0) {
        zone.getZoneParentNode().then(res => {
          if (res.code === 20000) {
            return resolve(res.data.zones)
          }
        })
      } else if (node.level === 1) {
        zone.getZoneChildByParentId(node.data.id).then(res => {
          if (res.code === 20000) {
            resolve(res.data.zones)
          }
        })
      }
      if (node.level > 1) {
        return resolve([])
      }
    },
    append(data) {
      this.formStatus = 'append'
      this.resetForm()
      this.zoneForm.parentId = data.id
      this.submitButTxt = '提交'
    },
    update(data) {
      this.zoneForm = data
      this.formStatus = 'update'
      this.submitButTxt = '更新'
    },
    remove(node, data) {
      this.$confirm('此操作将删除该zone, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        if (data.id !== undefined) {
          zone.deleteZone(data.id).then(res => {
            if (res.code === 20000) {
              this.$message({
                type: 'success',
                message: '删除成功!'
              })
              // 刷新页面
              this.$router.go(0)
            }
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    nodeClick(data, node, obj) {
      // 调用回显表单
      this.formStatus = 'echo'
      this.zoneForm = data
      console.log(data)
    },
    submitForm() {
      this.$refs['zoneForm'].validate((valid) => {
        if (valid) {
          this.zoneForm.level = this.zoneForm.parentId !== 0 ? 1 : 0
          // this.zoneForm.display = this.zoneForm.display ? 1 : 0

          // 判断表单类型
          if (this.formStatus === 'update') { // 更新
            zone.updateZone(this.zoneForm).then(res => {
              if (res.code === 20000) {
                // 更新数据
                this.$router.go(0)
              }
            })
          } else { // 添加
            zone.addZone(this.zoneForm).then(res => {
              if (res.code === 20000) {
                // 更新数据
                this.$router.go(0)
              }
            })
          }
        }
      })
    },
    resetForm() {
      this.zoneForm = {}
    }
  }
}
</script>

<style scoped>
.page-height {
  min-height: calc(100vh - 110px);
}

.con-flex {
  display: flex;
  align-items: stretch;
}

.cont-left {
  margin-right: 20px;
  flex-shrink: 0;
  width: 400px;
}

.cont-right {
  width: 100%;
  min-width: 800px;
  /*background-color: DodgerBlue;*/
}

/* 本页面css */
.cont-left {
  background-color: white;
  padding: 10px;
}

.custom-tree-node {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  padding-right: 8px;
}
</style>
