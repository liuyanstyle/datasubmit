Page({
  data: {
    date: '2018-06-01'
  },


  bindDateChange: function (e) {
    this.setData({
      date: e.detail.value
    })
  },




  formSubmit: function (e) {
    var that = this;
    var formData = e.detail.value;
    console.log(formData);
    wx.request({
      url: 'http://localhost:8080/miniprogram/cjhy',
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
  },

  formReset: function () { }
})