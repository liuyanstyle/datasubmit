Page({
  data: {
      multiIndex: [0, 0],
      multiArray: [['2017', '2018', '2019', '2020', '2021', '2022', '2025', '2026'], ['上半年', '下半年']]
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
        multiArray: this.data.multiArray,
        multiIndex: this.data.multiIndex
      }
    },




    formSubmit: function (e) {
      var that = this;
      var formData = e.detail.value;
      formData.year = this.data.multiArray[0][formData.year[0]] + this.data.multiArray[1][formData.year[1]]
      console.log(formData);

      wx.showModal({
        title: '提示',
        content: '提交之后无法修改，是否确认提交',
        success: function (res) {
          if (res.confirm) {
            console.log("hello");
            wx.request({
              url: 'http://localhost:8080/miniprogram/xkfw',
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

    formReset: function () { }
  })

