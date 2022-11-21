

<template style="background: #cccccc">
            <div :cursorColor="cursorColor" :leftname="leftname" :rightname="rightname" :yname="yname" :id="id" :title="title" :xAxisData1="xAxisData1" :xAxisData2="xAxisData2" :yAxisData1="yAxisData1" :yAxisData2="yAxisData2"  :color1="color1" :color2="color1"   :style="{width:width,height:height,margin:margin,background:background}">
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
            color1:{
                type:String,
                default:"#6EACDE"
            },
          color2:{
              type:String,
            default:"yellow"
          },
          cursorColor:{
              type:String,
            default:"#6CC272"
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
                this.chartColumn.setOption({
                  title: {

                      text: this.title,
                      textVerticalAlign:'middle',
                      bottom:'5',
                      textStyle: {
                        fontWeight:'normal',
                        fontSize:14,
                        lineHeight:0
                      },
                      left:'center'

                  },
                  tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                      type: 'cross',
                      label: {
                        // 鼠标移动  指示颜色
                        backgroundColor: this.cursorColor
                      }
                    }
                  },
                  legend: {
                    data:this.legend
                  },
                  toolbox: {
                    show: true,
                    feature: {
                      // dataView: {readOnly: false},
                      // restore: {},
                      // saveAsImage: {}
                    }
                  },
                  dataZoom: {
                    show: false,
                    start: 0,
                    end: 100
                  },
                  xAxis: [
                    {
                      type: 'category',
                      boundaryGap: true,
                      data: this.xAxisData1
                    },
                    {
                      type: 'category',
                      boundaryGap: true,
                      data: this.xAxisData2
                    }
                  ],
                  yAxis: [
                    {
                      type: 'value',
                      scale: true,
                      name: this.leftname,
                      min:0,

                      boundaryGap: [0.2, 0.2]
                    },
                    {
                      type: 'value',
                      scale: true,
                      name: this.rightname,
                      min:0,
                      boundaryGap: [0.2, 0.2]
                    }
                  ],
                  series: [
                    {
                      name: this.legend[0],
                      type: 'bar',
                      xAxisIndex: 1,
                      yAxisIndex: 1,
                      //柱状图颜色
                      color:this.color1,

                      data:this.yAxisData1
                    },
                    {
                      name: this.legend[1],
                      type: 'line',
                      color:this.color2,
                      symbol:'circle',//拐点设置为实心
                      data:this.yAxisData2
                    }
                  ]

                });
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

          deep:true
        }



    }
</script>
