package pl.put.poznan.transformer.logic;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JSONReader {

    TemplateBuilder object = new TemplateBuilder();

    void read_file(String file_name) throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader(file_name));
        JSONObject jo = (JSONObject) obj;

        Map header = ((Map)jo.get("header"));
        Iterator<Map.Entry> itr1 = header.entrySet().iterator();
        Map.Entry pair1 = itr1.next();
        boolean hEnable = pair1.getValue()=="true";
        pair1 = itr1.next();
        String hType = (String)pair1.getValue();
        pair1 = itr1.next();
        String hText = (String)pair1.getValue();

        Map footer = ((Map)jo.get("footer"));
        Iterator<Map.Entry> itr2 = footer.entrySet().iterator();
        Map.Entry pair2 = itr2.next();
        boolean fEnable = pair2.getValue()=="true";
        pair2 = itr2.next();
        String fText = (String)pair2.getValue();

        Map meta = ((Map)jo.get("meta"));
        Iterator<Map.Entry> itr3 = meta.entrySet().iterator();
        Map.Entry pair3 = itr3.next();
        String mTitle = (String)pair3.getValue();
        pair3 = itr3.next();
        String mType = (String)pair3.getValue();
        pair3 = itr3.next();
        String mDescription = (String)pair3.getValue();
        pair3 = itr3.next();
        String mImage = (String)pair3.getValue();

        // meta seo

        object = new TemplateBuilder.Builder()
                .headerEnable(hEnable)
                .headerType(hType)
                .headerText(hText)
                .footerEnable(fEnable)
                .footerText(fText)
                .metaTitle(mTitle)
                .metaType(mType)
                .metaDescription(mDescription)
                .metaImage(mImage)
                .metaSeoType(null)
                .build();
    }

}
