# xmlmapping
xmlからクラスにマッピングするので転んでしまったんです

json4sでXMLのデータにListが1件しかなかった場合にパースで転んでしまう不具合  
そもそもXMLにはListと明示的に判断する識別子はなく、同じキーがあるかどうかでしか判断できないというそもそものXMLの表現力の貧弱さが根本的なエラー  
そんなでもList[String]なクラスにマッピングするのに挑戦した記録

1. AnyRefに突っ込んで、中身がStringか、もしくはList[String]かでパターンマッチさせた   
2. 配列が1つか複数かxmlの状態で確認して、List(0件はNilにマッピングされる)か単品かでクラスまるごと分岐  

試して思ったけど、このやり方は実運用ではメンテするコストは上がる  
同じ内容のクラスが2つ存在するというのは悪手  
可能な限りJSONにフォーマット変更することをおすすめする  

他に良いやり方を思いついた方いれば教えて欲しい