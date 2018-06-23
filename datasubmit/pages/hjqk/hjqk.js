Page({
  data: {
    category: ['集体', '个人'],
    year: ['2017', '2018', '2019', '2020', '2021', '2022', '2023', '2024', '2025', '2026'],
    type: ['国家级', '省市级','校级','馆内','校企合作','国际合作','其他'],
    date: '2018-06-01',
    index: 0,
    index1: 0,
    index3: 0

  },

  bindPickerChange: function(e) {
    this.setData({
      index: e.detail.value
    })
  },
  bindPickerChange1: function(e) {
    this.setData({
      index1: e.detail.value
    })
  },


  bindPickerChange3: function (e) {
    this.setData({
      index3: e.detail.value
    })
  },

  bindDateChange: function (e) {
    this.setData({
      date: e.detail.value
    })
  }, 

  formSubmit: function(e) {
    var that = this;
    var formData = e.detail.value;
    formData.category = this.data.category[formData.category];
    formData.type = this.data.type[formData.type];
    formData.year = this.data.year[formData.year];
    console.log(formData);
    wx.showModal({
      title: '提示',
      content: '提交之后无法修改，是否确认提交',
      success: function(res) {
        if (res.confirm) {
          console.log("hello");
          wx.request({
            url: 'http://localhost:8080/miniprogram/hjqk',
            data: formData,
            method: 'POST',
            header: {
              'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            success: function(res) {
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

            fail: function() {

            },
            complete: function() {

            }
          })
        }

      }
    })
  },

  formReset: function() {}
})