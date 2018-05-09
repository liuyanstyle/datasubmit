Page({
    data:{
      category: ['课程','竞赛'],
      year:['2017','2018','2019','2020','2021','2022' ,'2023','2024','2025','2026'],
      index:0,
      index1:0,
  
    },
    
    bindPickerChange: function (e) {
      this.setData({
        index: e.detail.value
      })
    },
    bindPickerChange1: function (e) {
      this.setData({
        index1: e.detail.value
      })
    },
  

  
    formSubmit: function (e) {
      var that = this;
      var formData = e.detail.value;
      formData.category=this.data.category[formData.category];
      formData.year=this.data.year[formData.year];
      console.log(formData);
      wx.request({
        url: 'http://localhost:8080/miniprogram/xxsyjy',
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