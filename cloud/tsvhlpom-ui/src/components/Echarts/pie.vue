

<template style="background: #cccccc">
  <div :fMargin="fMargin" :textMargin="textMargin" :id="id" :color="color" :dataMap="dataMap"
       :title="title" :value="value"  :style="{width:width,height:height}">
  </div>
</template>
<script>
    import echarts from 'echarts'
    export default {
        props:{
            id:{
                type:String,
                default:"#pie"
            }
            ,
            width:{
                type:String,
                default:"100%"
            },
            height: {
                type:String,
                default:"1250px"
            },
            value:{
                type:String,
                default:"0%"
            },
            title:{
                type:String,
            },
            color:{
                type:String,
                default: "#38dd88"
            },
          textMargin:{
              type:String,
            default:"40%"
          },
          fMargin:{
              type:String,
            default:"50%"
          },
          dataMap:{
              type: Array
          },
        },
        data(){
            return {
                chartColumn: null,
            }
        },
        mounted() {
            this.drawLine();
        },
        methods: {
            //缓存命中率  饼图
            drawLine(){
                this.chartColumn = echarts.init(document.getElementById(this.id));
                this.chartColumn.setOption({
                  title: {
                    text: this.title,
                    subtext: '占比',
                    left: 'center'
                  },
                  tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                  },
                  legend: {
                    orient: 'vertical',
                    left: 'left'
                  },
                  series: [
                    {
                      name: '打卡',
                      type: 'pie',
                      radius: '50%',
                      data: this.dataMap,
                      emphasis: {
                        itemStyle: {
                          shadowBlur: 10,
                          shadowOffsetX: 0,
                          shadowColor: 'rgba(3,3,3,0.5)'
                        }
                      }
                    }
                  ]
                });
            },
        }  ,
      watch:{
        value:{
          handler(newValue,oldValue){
            this.value=newValue;
            this.drawLine();
          }
        },
        dataMap:{
          handler(newValue,oldValue){
            this.dataMap=newValue;
            this.drawLine();
          }
        },

        deep:true
      }
    }
</script>
