import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadXML {
	public static void PrintNode(NodeList nList)
	{
	for(int i=0;i<nList.getLength();i++) 
	{	
		Node node = nList.item(i);
		if(node.hasChildNodes()) {
			System.out.println("\n"+node.getNodeName());
			if(node.hasAttributes()) {
				System.out.println("\n"+node.getAttributes().item(0));
			}
			if(node.getChildNodes().getLength()==1)
			{
				System.out.println("\n"+node.getTextContent());
			}
			PrintNode(node.getChildNodes());
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try
    {
    	File file = new File("XMLFile.xml");
    	if(file.exists()) {
    		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
    		DocumentBuilder builder = fact.newDocumentBuilder();
    		Document doc = builder.parse("XMLFile.xml");
    		System.out.println(doc.getDocumentElement().getNodeName());
    		NodeList list = doc.getChildNodes();
    		PrintNode(list);
    	}
    }
    catch (Exception ex)
    {
    	System.out.println(ex.getMessage());
    }
	}

}
