Page({
  data:{
    category: ['图书','原版图书','影印图书','期刊报纸','数据库','电子图书','电子期'],
    year:['2017','2018','2019','2020','2021','2022' ,'2023','2024','2025','2026'],
    type:['中文','外文'],
    index:0,
    index1:0,
    index2:0

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

  bindPickerChange2: function (e) {
    this.setData({
      index2: e.detail.value
    })
  },

  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;
    formData.category=this.data.category[formData.category];
    formData.type=this.data.type[formData.type];
    formData.year=this.data.year[formData.year];
    console.log(formData);
    wx.showModal({
      title: '提示',
      content: '提交之后无法修改，是否确认提交',
      success:function(res){
        if(res.confirm){
          console.log("hello");
          wx.request({
            url: 'http://localhost:8080/miniprogram/zyjs',
            data: formData,
            method: 'POST',
            header: { 'content-type': 'application/x-www-form-urlencoded; charset=UTF-8' },
            success: function (res) {
              console.log(res.data)

              if (res.statusCode == 200) {
                wx.showToast({
                  title: '成功',
                  icon: 'success',
                  duration: 1000
                })
              } else {
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
        }

        }
    })
  },

  formReset: function () {
  }
})