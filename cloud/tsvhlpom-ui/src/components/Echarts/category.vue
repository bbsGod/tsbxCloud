

<template style="background: #cccccc">
            <div :cursorColor="cursorColor" :legend="legend" :leftname="leftname" :rightname="rightname" :yname="yname" :id="id" :title="title"
                 :xAxisData1="xAxisData1" :xAxisData2="xAxisData2"
                 :yAxisData1="yAxisData1" :yAxisData2="yAxisData2" :yAxisData3="yAxisData3"
                 :color1="color1" :color2="color1"
                 :style="{width:width,height:height,margin:margin,background:background}">
            </div>
</template>
<script>

    import echarts from 'echarts'
    export default {
        props:{
            width:{
                type:String,
                default:"100%"
            },
            height: {
                type:String,
                default:"350px"
            },
          yname:{
              type:String,
            default:""
          },
          legend: {
           type:Array
          },
          margin:{
            type:String,
            default:"0 auto"
          },
          background:{
            type:String,
            default:"white"
          },
            id:{
                type:String,
                default: "#category"
            }
            ,
            title:{
                type:String
            },
          leftname:{
              type:String,
          },
          rightname:{
            type:String,
          },
            xAxisData1:{
            type:Array
          },
          xAxisData2:{
            type:Array
          },
            yAxisData1:{
                type:Array
            },
          yAxisData2:{
            type:Array
          },
          yAxisData3:{
            type:Array
          },
            color1:{
                type:String,
                default:"#38dd88"
            },
          color2:{
              type:String,
            default:"#3d6af8"
          },
          color3:{
            type:String,
            default:"#f8b88e"
          },
          cursorColor:{
              type:String,
            default:"#3d6af8"
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
            drawLine(){
                this.chartColumn = echarts.init(document.getElementById(this.id));
                this.chartColumn.setOption(
                  {
                    tooltip: {
                      trigger: 'axis',
                      axisPointer: {
                        type: 'shadow'
                      }
                    },
                    legend: {},
                    grid: {
                      left: '3%',
                      right: '4%',
                      bottom: '3%',
                      containLabel: true
                    },
                    xAxis: [
                      {
                        type: 'category',
                        data: this.xAxisData1
                      }
                    ],
                    yAxis: [
                      {
                        type: 'value'
                      }
                    ],
                    series: [
                      {
                        name: '已登记正常',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                          focus: 'series'
                        },
                        color:this.color2,
                        data: this.yAxisData1
                      },
                      {
                        name: '已登记异常',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                          focus: 'series'
                        },
                        color:this.color3,
                        data: this.yAxisData3
                      },
                      {
                        name: '未登记',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                          focus: 'series'
                        },
                        color:this.color1,
                        data: this.yAxisData2
                      },
                    ]
                  }
                );
            },
        }
        ,
        watch:{
          xAxisData1:{
            handler(newValue,oldValue){

                this.xAxisData1=newValue;

              this.drawLine();
            }
          },
          xAxisData2:{
            handler(newValue,oldValue){

                this.xAxisData2=newValue;

              this.drawLine();
            }
          },
          yAxisData1:{
            handler(newValue,oldValue){

              this.yAxisData1=newValue;

              this.drawLine();
            }
          },
          yAxisData2:{
            handler(newValue,oldValue){
              this.yAxisData2=newValue;
              this.drawLine();
            }
          },
          yAxisData3:{
            handler(newValue,oldValue){
              this.yAxisData3=newValue;
              this.drawLine();
            }
          },

          deep:true
        }



    }
</script>
