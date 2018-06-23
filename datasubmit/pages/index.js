Page({
  data: {
    list: [
      {
        id: 'cbb',
        name: '采编部',
        open: false,
        pages: ['zyjs'],
        names: ['资源建设']
      },
      {
        id: 'xtjsb',
        name: '系统技术部',
        open: false,
        pages: ['webvisit'],
        names: ['门户系统访问']
      },
      {
        id: 'gxkjglzx',
        name: '共享空间管理中心',
        open: false,
        pages: ['kjsy'],
        names: ['空间使用']
      },
      {
        id: 'zhfwyydtgb',
        name:'综合服务与阅读推广部',
        open: false,
        pages:['wechatyy','zlwhhd'],
        names:['微信公众号运营','展览/文化活动']
      },
      {
        id:'xhdzfwb',
        name:'徐汇读者服务部',
        open: false,
        pages:['qwcd'],
        names:['全文传递']
      },
      {
        id:'qbb',
        name:'情报部',
        open: false,
        pages:['kjcxcscy'],
        names:['科技查新和查收查引']
      },
      {
        id:'bgs',
        name:'办公室',
        open: false,
        pages:['hzjl','cjhy','cbhy_jz','rcdwjs'],
        names:['合作交流','参加会议','承办会议/讲座','人才队伍建设']
      },
      {
        id:'dzz',
        name:'党总支、公会',
        open: false,
        pages:['dj&gh'],
        names:['党建与公会']
      },
      {
        id:'xkfwb',
        name:'学科服务部',
        pages:['xkfw','dzzyfw'],
        names:['学科服务','电子资源访问']
      },
      {
        id:'kjxxyjs',
        name:'科技信息研究所',
        pages:['xxsyjy','kycg','xmqk','hjqk'],
        names:['信息素养教育','科研成果','项目情况','获奖情况']
      }

    ]
  },
  kindToggle: function (e) {
    var id = e.currentTarget.id, list = this.data.list;
    for (var i = 0, len = list.length; i < len; ++i) {
      if (list[i].id == id) {
        list[i].open = !list[i].open
      } else {
        list[i].open = false
      }
    }
    this.setData({
      list: list
    });
  }
});
