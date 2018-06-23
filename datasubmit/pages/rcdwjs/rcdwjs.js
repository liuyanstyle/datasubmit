Page({
    data:{
      category: ['管领导','办公室','采编部','徐汇校区读者服务部','情报部','系统技术部','资源与学科服务部','科技信息研究所','奉贤校区读者服务部','综合服务与阅读推广部','(读者)共享空间管理中心'],
      year:['2017','2018','2019','2020','2021','2022' ,'2023','2024','2025','2026'],
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
      formData.year=this.data.year[formData.year];
      console.log(formData);
      wx.showModal({
        title: '提示',
        content: '提交之后无法修改，是否确认提交',
        success:function(res){
          if(res.confirm){
            console.log("hello");
            wx.request({
              url: 'http://localhost:8080/miniprogram/rcdwjs',
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