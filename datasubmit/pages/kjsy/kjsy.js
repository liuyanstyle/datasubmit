Page({
    data:{
      campus:['徐汇','奉贤'],
      multiArray:[
        {
          category:'研讨室',
          id:0,
          array:['徐汇305','徐汇201','徐汇303']
        },
        {
          category:'会议室',
          id:1,
          array:['XH_02/徐汇10202','XH_01/徐汇10201','XH_03/徐汇10203','XH_04/徐汇10204','XH_05/徐汇10205','FX_30/奉贤309','FX_60/奉贤609','FX_40/奉贤409','FX_50/奉贤509','FX_20/奉贤209','FX_61/奉贤603','FX_62/奉贤6066','FX_63/奉贤6067'],
        }
      ],
      index1:0,
      index2:0,
      index3:0,
      categorys:[],
      multi:[],
      multiIndex:[0,0],
      multiArray1:[['2017','2018','2019','2020','2021','2022','2025','2026'],['上半年','下半年']]

    },
    onLoad:function(){  
      var multiArray = this.data.multiArray  
      var categorys=[]  
      for (var i = 0; i < multiArray.length;i++){  
        categorys.push(multiArray[i].category,)   
      }  
      this.setData({ categorys: categorys ,multi: multiArray[this.data.index2].array})  
    },  

    bindPickerChange2: function (e) {  
      this.setData({ index2: e.detail.value, index3:0 })  
      var  multiArray = this.data.multiArray  
      this.setData({ multi: multiArray[this.data.index2].array})  
    }, 
     
    bindPickerChange3: function (e) {  
      this.setData({  
        index3: e.detail.value  
      })  
    },  

    bindPickerChange1: function (e) {
      this.setData({
        index1: e.detail.value
      })
    },

    bindMultiPickerChange: function (e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        multiIndex: e.detail.value
      })
    },
    bindMultiPickerColumnChange: function (e) {
      console.log('修改的列为', e.detail.column, '，值为', e.detail.value);
      var data = {
        multiArray1: this.data.multiArray,
        multiIndex: this.data.multiIndex
      }
    },

    formSubmit: function (e) {
      var that = this;
      var formData = e.detail.value;  //取得校区教室名,年份
      formData.campus=this.data.campus[formData.campus];
      formData.category=this.data.categorys[formData.category];
      formData.name=this.data.multi[formData.name];
      formData.year=this.data.multiArray1[0][formData.year[0]]+this.data.multiArray1[1][formData.year[1]]
      console.log(formData);
      wx.request({
        url: 'http://localhost:8080/miniprogram/kjsy',
        data:formData,
        method: 'POST',
        header: {
          'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        success: function (res) {
          console.log(res.data)
          
          if(res.statusCode==200){
            wx.showToast({
              title: '成功',
              icon: 'success',
              duration: 1000
            })
          }else{
            wx.showToast({
              title: '错误,请重输',
              icon: 'loading',
              duration: 1000
            })
          }
  
        },
        fail: function () {
  
        },
        complete: function () {
  
        }
      })
    },
  
    formReset: function () {
    }
  })