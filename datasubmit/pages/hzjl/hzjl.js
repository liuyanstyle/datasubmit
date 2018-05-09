Page({
    data:{
      category: ['调研','来访'], 
      index:0,
       date:'2018-06-01'
    },

    bindPickerChange: function (e) {
      this.setData({
        index: e.detail.value
      })
    },
    bindDateChange: function(e) {
      this.setData({
        date: e.detail.value
      })
    },




    formSubmit: function (e) {
      var that = this;
      var formData = e.detail.value;
      formData.category=this.data.category[formData.category];//取出webname

      console.log(formData);
      wx.request({
        url: 'http://localhost:8080/miniprogram/hzjl',
        data:formData,
        method: 'POST',
        header: {'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'},
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
  
    formReset: function () { }
  })