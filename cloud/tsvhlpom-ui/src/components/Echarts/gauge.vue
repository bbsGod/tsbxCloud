

<template style="background: #cccccc">
    <div :nameMarginTop="nameMarginTop" :id="id" :title="title" :value="value" :style="{width:width,height:height,fontSize:fontSize}"></div>
</template>
<script>

    import echarts from 'echarts'
    export default {
        props:{
            id:{
                type:String,
                default:"#gauge"
            },
            width:{
                type:String,
                default:"100%"
            },
            height: {
                type:String,
                default:"400px"
            },
            title:{
                type:String,
                default:"ms"
            },
            name:{
                type:String,
                default:"响应时间"
            }
            ,
            value:{
                type:Number,
                default:0
            },
          fontSize: {
              type:Number,
            default:10,
          }
          ,
          nameMarginTop:{
              type:String,
            default:"-40%",
          }
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
            //平均响应时间表图
            drawLine(){
                this.chartColumn = echarts.init(document.getElementById(this.id));
                this.chartColumn.setOption({
                    tooltip: {
                        formatter: this.value+this.title
                    },
                    toolbox: {
                        feature: {
                        }
                    },
                  axisTick:{
                    length:1
                  },
                    series: [
                        {
                          min: 0,
                          max: 1000,
                            type: 'gauge',
                            detail: {formatter: '{value}'+this.title},
                            data: [{value: this.value, name: this.name}],
                            radius:'100%',
                          title:{
                            show:true,
                            offsetCenter: [0,this.nameMarginTop]
                          },
                          splitLine: {           // 分隔线
                            length: 20,
                            // 属性length控制线长
                            lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                              color: 'auto'
                            }
                          },
                          axisLine: {            // 坐标轴线
                            lineStyle: {       // 属性lineStyle控制线条样式
                              width: 15
                            }
                          },
                            detail:{
                              formatter:'{value}ms'
                              ,
                              textStyle:{
                                fontSize:this.fontSize
                              }
                            }


                        }
                    ]
                });
            }
        },
      watch:{
        value:{
          handler(newValue,oldValue){
            this.value=newValue;
            this.drawLine();
          }
        },
        deep:true
      }
    }
</script>
