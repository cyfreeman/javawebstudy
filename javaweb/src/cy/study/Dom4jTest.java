package cy.study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.Iterator;


public class Dom4jTest {

    @Test
    public void test1(){
        SAXReader saxReader = new SAXReader();
        try {
            Document read = saxReader.read("src/books.xml");
            System.out.println(read);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /*
    读取books.xml文件生成Book类
     */
    @Test
    public void test02() throws Exception {
        //1、读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2、通过document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //3、通过根元素获取book标签对象
        Element book = rootElement.element("book");
        for(Iterator<Element> i = rootElement.elementIterator() ; i.hasNext();){
            Element element = i.next();

            String price = element.elementText("price");
            String author = element.elementText("author");
            String sn = element.attributeValue("sn");
            String name = element.elementText("name");

            System.out.println(new Book(sn,name,Double.parseDouble(price),author).toString());
        }
        //4、遍历，处理每个book标签转换为book类
    }
}
