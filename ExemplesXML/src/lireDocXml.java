import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
public class lireDocXml {

	public static void main(String[] args) throws ParserConfigurationException{
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try{
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File ("D:/ZFYI6S/Mes Documents/eclipse_workspace/ExemplesXML/src/Test2.xml"));
			// Affiche la version de XML
			 System.out.println(document.getXmlVersion ());
			// Affiche l'encodage
			 System .out. println(document.getXmlEncoding ());
			// Affiche s'il s'agit d'un document standalone
			 System .out. println (document.getXmlStandalone ());
			 
			 //récupération de la racine
			 final Element racine = document . getDocumentElement ();
			 //affichage du nom de la racine
			 System .out. println ( racine . getNodeName ());
			 
			 //récupération des noeuds
			 final NodeList racineNoeuds = racine . getChildNodes ();
			 
			 //affichage du nom des noeuds qui sont des éléments
			 final int nbRacineNoeuds = racineNoeuds . getLength ();
			 for ( int i = 0; i< nbRacineNoeuds ; i ++) {
				 if( racineNoeuds . item (i). getNodeType () == Node . ELEMENT_NODE )
				 {
				 final Node personne = racineNoeuds . item (i);
				 System.out.println ( personne.getNodeName ());
				 }
				 }
			 //affichage de la valeur de l'attribut sexe
			 for ( int i = 0; i< nbRacineNoeuds ; i ++) {
				 if( racineNoeuds . item (i). getNodeType () == Node . ELEMENT_NODE )
				 {
				 final Element personne = ( Element ) racineNoeuds.item (i)
				 ;
				 System.out.println ( personne . getNodeName ());
				 System.out.println (" sexe : " + personne.getAttribute ("sexe"));
				 
				//récupération du nom et du prénom
				 final NodeList noms = personne.getElementsByTagName ("nom");
				 final Element nom = ( Element ) personne . getElementsByTagName ("nom").item(0);
				  System.out.println (nom. getTextContent ());
				  
				//récupération des numéros de téléphone
				  final NodeList telephones = personne . getElementsByTagName ("telephone");
				  final int nbTelephonesElements = telephones . getLength ();
				  for (int j = 0; j< nbTelephonesElements ; j ++) {
				  final Element telephone = ( Element ) telephones . item (j);
				  System .out. println ( telephone . getAttribute ("type") + " : " + telephone . getTextContent ());
						   }
				  }
				 }
			 
			 
		}
		catch(final ParserConfigurationException e){
			e.printStackTrace();
		}
		catch(final SAXException e){
			e.printStackTrace();
		}
		catch(final IOException e){
			e.printStackTrace();
		}
		
	 
	}
}
