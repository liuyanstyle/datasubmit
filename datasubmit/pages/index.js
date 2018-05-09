Page({
    data: {
        list: [
            {
                id: 'form',
                name: '表单',
                open: false,
                pages: ['hzjl', 'kjcxcscy', 'kjsy', 'qwcd', 'webvisit','wechatyy','xxsyjy','zyjs','zlwhhd','cjhy'],
                names:['合作交流','科技查新和查收查引','空间使用','全文传递','门户系统访问','微信公众号运营','信息素养教育','资源建设','展览/文化活动','参加会议']
            },

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
