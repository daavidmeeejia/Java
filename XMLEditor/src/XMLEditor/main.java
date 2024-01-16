package XMLEditor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import EscribirXMLusandoDOM.ingrediente;

public class main {

	private static Scanner sc = new Scanner(System.in);

	private static DocumentBuilderFactory dbf;
	private static DocumentBuilder db;
	private static DOMImplementation imp;
	// private static Element products;
	private static Document document;

	public static void main(String[] args) {

		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			assert db != null;
			imp = db.getDOMImplementation();
			document = imp.createDocument(null, null, null);
			document.setXmlVersion("1.0");
			document.setXmlStandalone(true);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Program
		System.out.println("Bienvenido al programa de XML");
		System.out.println("-----------------------------");

		int option = 0;
		do {
			System.out.println("Elige una opción: ");
			// sc.nextLine();
			menu();
			option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				saveXML();
				break;

			case 2:
				showXML();
				break;

			case 3:
				addElement();
				break;

			case 4:
				deleteElement();
				break;

			case 5:
				System.out.println("¡Hasta pronto!");
				sc.close();
			default:
			}
		} while (option != 5);
		// System.out.println("Opción incorrecta, saliendo del programa.");
		sc.close();
	}

	// Methods
	private static void deleteElement() {
		try {
			document = db.parse(new File("proyecto/nio/Trabajo1p3.xml"));
			System.out.println("Introduce el nombre del producto que deseas borrar: ");
			String nameProd = sc.nextLine();
			// sc.nextLine();
			boolean deleted = deleteProductInTheXML(nameProd);
			if (deleted) {

				saveNewInfoToXML();

				System.out.println("El producto " + nameProd + " se ha borrado con éxito.");
				System.out.println("-----------------------------------------------------");
				Thread.sleep(1500);
			} else {
				System.err.println("El producto " + nameProd + " no se ha encontrado.");
				System.out.println("-------------------------------------------------");
				Thread.sleep(1500);
			}
		} catch (SAXException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean deleteProductInTheXML(String nameProd) {
		NodeList XMLProducts = document.getElementsByTagName("product");
		for (int i = 0; i < XMLProducts.getLength(); i++) {
			Element p = (Element) XMLProducts.item(i);
			String nameProduct = String.valueOf(p.getElementsByTagName("name").item(0).getTextContent());
			if (nameProduct.equals(nameProd)) {
				p.getParentNode().removeChild(p);
				return true;
			}
		}
		return false;
	}

	private static void addElement() {
		try {
			document = db.parse(new File("proyecto/nio/Trabajo1p3.xml"));
			Element p = document.getDocumentElement();

			createProduct(p, document);
			saveNewInfoToXML();
			
			System.out.println("-----------------------------");
			Thread.sleep(1800);
		} catch (SAXException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void showXML() {
		try {
			Path XML = Path.of("proyecto/nio/Trabajo1p3.xml");
			if (XML.toFile().exists()) {
				Document XMLToShow = db.parse(XML.toFile());
				XMLToShow.getDocumentElement().normalize();
				NodeList nl = XMLToShow.getElementsByTagName("products").item(0).getChildNodes();
				System.out.println("Productos: ");
				for (int i = 0; i < nl.getLength(); i++) {
					Node n = nl.item(i);
					if (n.getNodeType() == Node.ELEMENT_NODE) {
						elementChanger(n);
					}
				}
			}
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void elementChanger(Node n) {
		Element changer = (Element) n;
		switch (changer.getNodeName().trim()) {
		case "product":
				System.out.println("\tProducto: ");
				System.out.print("\t\tID: ");
				System.out.println(getAttribute(changer, "id"));
				elementChanger(changer.getFirstChild());
			break;
		case "name":
				System.out.print("\t\tNombre: ");
				System.out.println(getText(changer));
				elementChanger(changer.getNextSibling());
			break;
		case "price":
				System.out.print("\t\tPrecio: ");
				System.out.println(getText(changer));
				elementChanger(changer.getNextSibling());
			break;
		case "date":
				System.out.print("\t\tFecha: ");
				System.out.println(getText(changer));
				//elementChanger(changer);
			break;
		}
	}

	private static String getText(Element changer) {
		return changer.getTextContent();
	}

	private static String getAttribute(Element changer, String id) {
		return changer.getAttribute(id);
	}

	private static void saveXML() {
		File xml = new File("proyecto/nio/Trabajo1p3.xml");
		if (!xml.exists()) {
			// DocumentBuilder db;
			try {
				Element products = document.createElement("products");
				document.appendChild(products);

				createProduct(products, document);
				saveNewInfoToXML();
			} catch (TransformerFactoryConfigurationError e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Fichero XML creado y guardado correctamente.");
			System.out.println("--------------------------------------------");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}

		} else {
			System.out.println("El fichero XML ya esta creado y guardado correctamente.");
			System.out.println("-------------------------------------------------------");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static void saveNewInfoToXML() {
		try {
			DOMSource s = new DOMSource(document);
			StreamResult r = new StreamResult(new File("proyecto/nio/Trabajo1p3.xml"));
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.transform(s, r);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createProduct(Element products, Document document) {
		System.out.print("ID del producto: ");
		String idNewProduct = sc.nextLine();
		System.out.print("Nombre del producto: ");
		String nameNewProduct = sc.nextLine();
		System.out.print("Precio del producto: ");
		String priceNewProduct = sc.nextLine();
		System.out.print("Fecha de entrada: ");
		String dateNewProduct = sc.nextLine();

		Element product = document.createElement("product");
		product.setAttribute("id", idNewProduct);

		Element name = document.createElement("name");
		Text nameInfo = document.createTextNode(nameNewProduct);
		name.appendChild(nameInfo);

		Element price = document.createElement("price");
		Text priceInfo = document.createTextNode(priceNewProduct + "€");
		price.appendChild(priceInfo);

		Element date = document.createElement("date");
		Text dateInfo = document.createTextNode(dateNewProduct);
		date.appendChild(dateInfo);

		product.appendChild(name);
		product.appendChild(price);
		product.appendChild(date);

		products.appendChild(product);
	}

	private static void menu() {
		System.out.println("1. Guardar la info del XML.");
		System.out.println("2. Recuperar la info del XML.");
		System.out.println("3. Añadir nuevo objeto en el XML.");
		System.out.println("4. Borrar objeto del XML.");
		System.out.println("5. Salir.");
	}
}
