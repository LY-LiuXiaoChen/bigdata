package org.example;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.lazy.LazyString;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class fanyiUDF extends GenericUDF {
    static Map<String,String> map=new HashMap<>();
    static {
        try {
            InputStream inputStream = fanyiUDF.class.getResourceAsStream("/country.dict");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line=null;
            while ((line=reader.readLine())!=null){
                String[] split = line.split("\t");
                String code=split[0];
                String name=split[1];
                map.put(code,name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    //校验数据
    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        //校验参数是否为1个
        if(objectInspectors.length!=1){
            throw new UDFArgumentException("参数不为1，输入多了");
        }
        ObjectInspector inspector = objectInspectors[0];

        if(!inspector.getCategory().equals(ObjectInspector.Category.PRIMITIVE)){
            throw new UDFArgumentException("不是基本数据类型。");
        }
        if(!inspector.getTypeName().equalsIgnoreCase(PrimitiveObjectInspector.PrimitiveCategory.STRING.name())){
            throw new UDFArgumentException("不是基本数据类型中的string类型");
        }

        return PrimitiveObjectInspectorFactory.writableStringObjectInspector;
    }

    //业务逻辑
    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        Object obj = deferredObjects[0].get();
        String code=null;
        if(obj instanceof LazyString){
            LazyString lazyString=(LazyString) obj;
            Text text = lazyString.getWritableObject();
            code = text.toString();
        }else if(obj instanceof Text){
            Text text=(Text) obj;
            code=text.toString();
        }else {
            code=(String) obj;
        }

        String name = map.get(code);

        Text outT = new Text();
        outT.set(name);
        return outT;
    }

    //相关报错信息
    @Override
    public String getDisplayString(String[] strings) {
        return Arrays.toString(strings);
    }
}
