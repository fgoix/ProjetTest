import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax .xml.transform.TransformerException ;
import javax .xml.transform.TransformerConfigurationException ;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.security.transforms.TransformationException;

public class EcrireDocXml {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException{
		final DocumentBuilderFactory factory = DocumentBuilderFactory .
				newInstance ();
		//création d'un parseur
		try{
		final DocumentBuilder builder = factory.newDocumentBuilder ();
		
		//création d'un document vierge à partir du parseur
		final Document document = builder.newDocument();
		
		//création de l'élément racine répertoire
		final Element racine = document.createElement ("repertoire");
		
		//ajout de l'élément à notre document
		document.appendChild (racine);
		
		//création du commentaire
		final Comment commentaire = document.createComment ("John DOE");
		
		//ajout au doc
		racine.appendChild (commentaire);
		
		//création de la balise personne
		final Element personne = document.createElement ("personne");
		racine.appendChild (personne);
		
		//ajout de l'attribut sexe à personne ainsi que sa valeur
		personne.setAttribute ("sexe", "masculin");
		
		//création et ajout des balises nom et prénom
		final Element nom = document . createElement ("nom");
		final Element prenom = document . createElement ("prenom");
		personne.appendChild (nom);
		personne.appendChild (prenom);
		
		//création etajout des téléphones
		final Element telephones = document.createElement ("telephones");
		final Element fixe = document.createElement ("telephone");
		fixe.appendChild ( document . createTextNode ("01 02 03 04 05"));
		fixe.setAttribute ("type", "fixe");
		final Element portable = document . createElement ("telephone");
		portable.appendChild ( document . createTextNode ("06 07 08 09 10"));
		portable.setAttribute ("type", "portable");
		telephones.appendChild ( fixe );
		telephones.appendChild ( portable );
		personne.appendChild ( telephones );
		
		//affichage du résultat ;création d'une instance de TransformerFactory
		final TransformerFactory transformerFactory = TransformerFactory.newInstance ();
		
		//création d'un objet Transformer
		final Transformer transformer = transformerFactory.newTransformer ();
		
		final DOMSource source = new DOMSource ( document );
		// Code à utiliser pour afficher dans un fichier
		final StreamResult sortie = new StreamResult ( new File ("D:/ZFYI6S/Mes Documents/eclipse_workspace/ExemplesXML/src/file.xml"));
		
		// Code à utiliser pour afficher dans la console
		//final StreamResult sortie = new StreamResult ( System .out);
		transformer.transform (source,sortie);
		
		//écriture du prologue et le formatage de l'affichage
		transformer.setOutputProperty ( OutputKeys.VERSION , "1.0");
		transformer.setOutputProperty ( OutputKeys.ENCODING , "UTF -8");
		transformer.setOutputProperty ( OutputKeys.STANDALONE , "yes");
		
		//pour indenter le doc;Chaque niveau différent de notre doc XML sera alors décalé de 2 espaces
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		transformer.setOutputProperty("{http ://xml.apache.org/xslt}indent-amount","2");
		}
		
	
		catch(final ParserConfigurationException e){
			e.printStackTrace();
		}
		catch(TransformerConfigurationException e){
			e.printStackTrace();
		}
	}
}
