# Document INDEX

- [Database Script](./doc/DatabaseScript.md)
- [SQL Statement](./doc/SQLStatement.md)
- [Test Data](./doc/TestData.md)
- [SQL with Mapper](./doc/SQLwithMapper.md)


# 前端数据

商品列表
```json
[
  {
    "name":"情侣装夏装情侣款2020年夏季两件套装连衣裙气质洋气衬衫拼色潮流",
    "price":"88.00-142.00",
    "address":"广东广州",
    "argument1":"颜色:红色,黄色,蓝色,绿色,青色",
    "argument2":"尺码:S,M,L,XL,2XL",
    "amount":"888",
    "picture":"1.jpg,2.jpg,3.jpg,4.jpg,5.jpg",
    "details":"![](1.jpg)![2.jpg]"
  }
]
```



# DOME

```js
var text = "![](TB11FXw1.jpg)![](TB11FXw2.jpg)(center,black,block,14)::重要说明%%%(center,black,block,14)::可乐瓶的位置随着尺码不同而不同，其原因咨询过专柜店长，答复如下：%%%(center,black,block,14)::此款商品的工艺是先印染，再裁剪。%%%(center,black,block,14)::所以尺码越小，瓶子月接近底部边线，甚至会有平底缺失（如S码无平底，M码平底压线）%%%(center,black,block,14)::尺码越大，瓶子底部越远离底部边线，达到官方概念图的效果（如L码，和 XL码）%%%(center,black,block,14)::并且每件衣服裁剪的程度不同也会存在同一尺码瓶子位置有偏差。%%%(center,black,block,14)::综上，介意的亲慎重考虑后再下单，切勿因此产生不必要的麻烦，。%%%![](TB11FXw3.jpg)![](TB11FXw4.jpg)![](TB11FXw5.jpg)![](TB11FXw6.jpg)![](TB11FXw7.jpg)![](TB11FXw8.jpg)![](TB11FXw9.jpg)![](TB11FXw10.jpg)(center,#e6232b,block,16)::Coca-Cola（コカ�9�9コーラ グッズ） ユニセックス Tシャツ ストローinボトル チャコール";

// 格式化商品详情文本
var result, pattern = /\(\w*\,(\#)?\w*,\w*,\w*\)\:\:/g;
while((result = pattern.exec(text)) != null) {  // 转样式表记为CSS样式格式
    var itmes = result[0].match(/\w*\,(\#)?\w*,\w*,\w*/)[0].split(",");
    console.log(itmes);
    itmes[0] = "text-align:" + itmes[0];
    itmes[1] = "color:" + itmes[1];
    itmes[2] = "display:" + itmes[2];
    itmes[3] = "font-size:" + itmes[3] + "px";
    var style = " style=\""+itmes.join(";")+"\"";
    text = text.slice(0,result.index)+"<p"+style+">"+text.slice(pattern.lastIndex,text.length-1)
}
// 转换结束标记，图片标记
text = text.replace(/%%%/g,"</p>").replace(/\!\[\]\(/g,"<img style='width:100%' src='http://localhost:8080/file/download/").replace(/\)/g,"/' />");

// 填充
document.write(text);
```


