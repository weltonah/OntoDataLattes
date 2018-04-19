package br.com.OntologyTeste;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Nonnull;

import org.junit.Test;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.ReasonerProgressMonitor;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;

import br.com.Ontology.BuscarXmlToPessoa;
import br.com.Ontology.OntologyDAO;
import br.com.Ontology.modelo.OntoPessoa;
import br.com.converter.ConverterFile;
import br.com.converter.FixString;

public class ReasonTeste {
	@Test
	public void DadosGerais() throws Exception {
		// System.out.println("Funcional");
		// long tempoInicio = System.currentTimeMillis();
		// OWLOntologyManager manager;
		// OWLOntology ontology;
		// IRI DATALATTESIRI =
		// IRI.create("http://www.datalattes.com/ontologies/datalattes.owl");
		// File owlfile = new
		// ClassPathResource("static/OWL/datalattesSimples.owl").getFile();
		// manager = OWLManager.createOWLOntologyManager();
		// ontology = manager.loadOntologyFromOntologyDocument(owlfile);
		// OWLDataFactory factory = manager.getOWLDataFactory();
		// ontology.classesInSignature().forEach(cls ->
		// System.out.println(cls.getIRI().getFragment()));
		// ontology.logicalAxioms().forEach(System.out::println);
		// ontology.objectPropertiesInSignature().forEach(System.out::println);
		// OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#",
		// "orientou");
		// ontology.objectPropertiesInSignature().forEach(System.out::println);
		// ontology.classesInSignature().forEach(u ->
		// System.out.println(u.getIRI()));
		// ontology.objectPropertiesInSignature().forEach(u -> System.out.println(u.));

		// ontology.signature().forEach(System.out::println);
		// ontology.signature().filter(e ->
		// !e.isBuiltIn() && e.getIRI().getRemainder().orElse("").startsWith("r")
		// ).forEach(System.out::println);
		// OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#",
		// "relacaoBanca");
		// Logger LOG = LoggerFactory.getLogger(ReasonTeste.class);
		// ReasonerProgressMonitor progressMonitor = new
		// LoggingReasonerProgressMonitor(LOG, "Loginference");
		// OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		// OWLReasonerFactory rf = new ReasonerFactory();
		// OWLReasoner r = rf.createReasoner(ontology, config);
		// r.precomputeInferences(InferenceType.CLASS_HIERARCHY,
		// InferenceType.CLASS_ASSERTIONS,
		//
		// InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		// // r.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		// // r.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		// r.getObjectPropertyDomains(obj).forEach(System.out::println);
		// System.out.println("Tempo Total: " + (System.currentTimeMillis() -
		// tempoInicio));
		//
		// ontology.classesInSignature().forEach(u -> {
		// // System.out.println(u.getIRI());
		//
		// NodeSet<OWLClass> instances = r.getObjectPropertyDomains(obj);
		// // NodeSet<OWLNamedIndividual> instances = r.getInstances(u,true);
		// instances.entities().forEach(i -> {
		// // System.out.println(i.getIRI());
		// });
		// });

	}

	@Test
	public void TesteProjetoPesquisa() throws Exception {
		// FuncTesteProjetoPesquisa();
	}

	@Test
	public void TesteBanca() throws Exception {
		// FuncTesteBanca();
	}

	@Test
	public void TesteOrientacao() throws Exception {
		// FuncTesteOrientacao();
	}

	@Test
	public void TestetrabalhoEvento() throws Exception {
		FuncTestetrabalhoEvento();
	}

	public void FuncTestetrabalhoEvento() throws Exception {
		System.out.println("TrabalhoEvento");
		OWLOntologyManager manager;
		OWLOntology ontology;
		IRI DATALATTESIRI = IRI.create("http://www.datalattes.com/ontologies/datalattes.owl");
		String nomeFile = "Evento.owl";
		OntologyDAO ontoDao = new OntologyDAO(nomeFile);
		FixString fixString = new FixString();
		ArrayList<String> Namexml = new ArrayList<>();
		Namexml.add("Alessandreiacurriculo.xml");
		Namexml.add("Alexcurriculo.xml");
		Namexml.add("AndreLuizcurriculo.xml");
		Namexml.add("BernardoMartinscurriculo.xml");
		Namexml.add("Carloscurriculo.xml");
		Namexml.add("Cirocurriculo.xml");
		Namexml.add("Edelbertocurriculo.xml");
		Namexml.add("EdmarOliveiracurriculo.xml");
		Namexml.add("EduardoBarrelecurriculo.xml");
		Namexml.add("EduardoPaganicurriculo.xml");
		Namexml.add("FabricioMartinscurriculo.xml");
		Namexml.add("Fernandacurriculo.xml");
		Namexml.add("Gleiphcurriculo.xml");
		Namexml.add("Hedercurriculo.xml");
		for (String string : Namexml) {
			File owlfile = new ClassPathResource("static/testFile/" + string).getFile();
			Document xmlfile = ConverterFile.ConverterFileToDocument(owlfile);
			BuscarXmlToPessoa preencherXMLtoOnto = new BuscarXmlToPessoa(xmlfile);
			OntoPessoa pessoa = new OntoPessoa(fixString.corrigirString(preencherXMLtoOnto.NomeCompleto()),
					fixString.corrigirString(preencherXMLtoOnto.IDLattes()),
					fixString.corrigirString(preencherXMLtoOnto.UltimaAtualizacao()));
			preencherXMLtoOnto.buscarXML(pessoa);
			ontoDao.preencherDadosGerais(pessoa);
			ontoDao.preencherEvento(pessoa);
			ontoDao.preencherOrgEvento(pessoa);
			ontoDao.preencherTrabalhoEvento(pessoa);
			ontoDao.saveOntologyDAO(new FunctionalSyntaxDocumentFormat());
		}
		long tempoInicio = System.currentTimeMillis();
		File owlfile = new File(System.getProperty("user.dir") + "/" + nomeFile);
		manager = OWLManager.createOWLOntologyManager();
		ontology = manager.loadOntologyFromOntologyDocument(owlfile);
		OWLDataFactory factory = manager.getOWLDataFactory();
		Logger LOG = LoggerFactory.getLogger(ReasonTeste.class);
		ReasonerProgressMonitor progressMonitor = new LoggingReasonerProgressMonitor(LOG, "Loginference");
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasonerFactory rf = new ReasonerFactory();
		OWLReasoner r = rf.createReasoner(ontology, config);
		r.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#", "relacaoTrabalhoEvento");
		OWLClass ce = factory.getOWLClass(DATALATTESIRI + "#", "Pessoa");
		r.getInstances(ce).forEach(u -> u.entities().forEach(i -> {
			System.out.println("@@@@@@" + i.getIRI() + "@@@@@");
			r.objectPropertyValues(i, obj).forEach(y -> {
				System.out.println(y.getIRI());
			});
		}));
		System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));
	}

	public void FuncTesteOrientacao() throws Exception {
		System.out.println("Orientacao");
		OWLOntologyManager manager;
		OWLOntology ontology;
		IRI DATALATTESIRI = IRI.create("http://www.datalattes.com/ontologies/datalattes.owl");
		String nomeFile = "Orientacao.owl";
		OntologyDAO ontoDao = new OntologyDAO(nomeFile);
		FixString fixString = new FixString();
		ArrayList<String> Namexml = new ArrayList<>();
		Namexml.add("Alessandreiacurriculo.xml");
		Namexml.add("Alexcurriculo.xml");
		Namexml.add("AndreLuizcurriculo.xml");
		Namexml.add("BernardoMartinscurriculo.xml");
		Namexml.add("Carloscurriculo.xml");
		Namexml.add("Cirocurriculo.xml");
		Namexml.add("Edelbertocurriculo.xml");
		Namexml.add("EdmarOliveiracurriculo.xml");
		Namexml.add("EduardoBarrelecurriculo.xml");
		Namexml.add("EduardoPaganicurriculo.xml");
		Namexml.add("FabricioMartinscurriculo.xml");
		Namexml.add("Fernandacurriculo.xml");
		Namexml.add("Gleiphcurriculo.xml");
		Namexml.add("Hedercurriculo.xml");
		for (String string : Namexml) {
			File owlfile = new ClassPathResource("static/testFile/" + string).getFile();
			Document xmlfile = ConverterFile.ConverterFileToDocument(owlfile);
			BuscarXmlToPessoa preencherXMLtoOnto = new BuscarXmlToPessoa(xmlfile);
			OntoPessoa pessoa = new OntoPessoa(fixString.corrigirString(preencherXMLtoOnto.NomeCompleto()),
					fixString.corrigirString(preencherXMLtoOnto.IDLattes()),
					fixString.corrigirString(preencherXMLtoOnto.UltimaAtualizacao()));
			preencherXMLtoOnto.buscarXML(pessoa);
			ontoDao.preencherDadosGerais(pessoa);
			ontoDao.preencherFormacao(pessoa);
			ontoDao.saveOntologyDAO(new FunctionalSyntaxDocumentFormat());
		}
		long tempoInicio = System.currentTimeMillis();
		File owlfile = new File(System.getProperty("user.dir") + "/" + nomeFile);
		manager = OWLManager.createOWLOntologyManager();
		ontology = manager.loadOntologyFromOntologyDocument(owlfile);
		OWLDataFactory factory = manager.getOWLDataFactory();
		Logger LOG = LoggerFactory.getLogger(ReasonTeste.class);
		ReasonerProgressMonitor progressMonitor = new LoggingReasonerProgressMonitor(LOG, "Loginference");
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasonerFactory rf = new ReasonerFactory();
		OWLReasoner r = rf.createReasoner(ontology, config);
		r.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#", "relacaoGuia");
		OWLClass ce = factory.getOWLClass(DATALATTESIRI + "#", "Pessoa");

		r.getInstances(ce).forEach(u -> u.entities().forEach(i -> {
			System.out.println("@@@@@@" + i.getIRI() + "@@@@@");
			r.objectPropertyValues(i, obj).forEach(y -> {
				System.out.println(y.getIRI());
			});
		}));
		System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));
	}

	public void FuncTesteBanca() throws Exception {
		System.out.println("Banca");
		OWLOntologyManager manager;
		OWLOntology ontology;
		IRI DATALATTESIRI = IRI.create("http://www.datalattes.com/ontologies/datalattes.owl");
		String nomeFile = "Banca.owl";
		OntologyDAO ontoDao = new OntologyDAO(nomeFile);
		FixString fixString = new FixString();
		ArrayList<String> Namexml = new ArrayList<>();
		Namexml.add("Alessandreiacurriculo.xml");
		Namexml.add("Alexcurriculo.xml");
		Namexml.add("AndreLuizcurriculo.xml");
		Namexml.add("BernardoMartinscurriculo.xml");
		Namexml.add("Carloscurriculo.xml");
		Namexml.add("Cirocurriculo.xml");
		Namexml.add("Edelbertocurriculo.xml");
		Namexml.add("EdmarOliveiracurriculo.xml");
		Namexml.add("EduardoBarrelecurriculo.xml");
		Namexml.add("EduardoPaganicurriculo.xml");
		Namexml.add("FabricioMartinscurriculo.xml");
		Namexml.add("Fernandacurriculo.xml");
		Namexml.add("Gleiphcurriculo.xml");
		Namexml.add("Hedercurriculo.xml");
		for (String string : Namexml) {
			File owlfile = new ClassPathResource("static/testFile/" + string).getFile();
			Document xmlfile = ConverterFile.ConverterFileToDocument(owlfile);
			BuscarXmlToPessoa preencherXMLtoOnto = new BuscarXmlToPessoa(xmlfile);
			OntoPessoa pessoa = new OntoPessoa(fixString.corrigirString(preencherXMLtoOnto.NomeCompleto()),
					fixString.corrigirString(preencherXMLtoOnto.IDLattes()),
					fixString.corrigirString(preencherXMLtoOnto.UltimaAtualizacao()));
			preencherXMLtoOnto.buscarXML(pessoa);
			ontoDao.preencherDadosGerais(pessoa);
			ontoDao.preencherBanca(pessoa);
			ontoDao.saveOntologyDAO(new FunctionalSyntaxDocumentFormat());
		}
		long tempoInicio = System.currentTimeMillis();
		File owlfile = new File(System.getProperty("user.dir") + "/" + nomeFile);
		manager = OWLManager.createOWLOntologyManager();
		ontology = manager.loadOntologyFromOntologyDocument(owlfile);
		OWLDataFactory factory = manager.getOWLDataFactory();
		Logger LOG = LoggerFactory.getLogger(ReasonTeste.class);
		ReasonerProgressMonitor progressMonitor = new LoggingReasonerProgressMonitor(LOG, "Loginference");
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasonerFactory rf = new ReasonerFactory();
		OWLReasoner r = rf.createReasoner(ontology, config);
		r.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#", "relacaoBanca");
		OWLClass ce = factory.getOWLClass(DATALATTESIRI + "#", "Pessoa");

		r.getInstances(ce).forEach(u -> u.entities().forEach(i -> {
			System.out.println("@@@@@@" + i.getIRI() + "@@@@@");
			r.objectPropertyValues(i, obj).forEach(y -> {
				System.out.println(y.getIRI());
			});
		}));
		System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));
	}

	public void FuncTesteProjetoPesquisa() throws Exception {
		System.out.println("Funcional");
		OWLOntologyManager manager;
		OWLOntology ontology;
		IRI DATALATTESIRI = IRI.create("http://www.datalattes.com/ontologies/datalattes.owl");
		String nomeFile = "ProjetoPesquisa.owl";
		OntologyDAO ontoDao = new OntologyDAO(nomeFile);
		FixString fixString = new FixString();
		ArrayList<String> Namexml = new ArrayList<>();
		Namexml.add("Alessandreiacurriculo.xml");
		Namexml.add("Alexcurriculo.xml");
		Namexml.add("AndreLuizcurriculo.xml");
		Namexml.add("BernardoMartinscurriculo.xml");
		Namexml.add("Carloscurriculo.xml");
		Namexml.add("Cirocurriculo.xml");
		Namexml.add("Edelbertocurriculo.xml");
		Namexml.add("EdmarOliveiracurriculo.xml");
		Namexml.add("EduardoBarrelecurriculo.xml");
		Namexml.add("EduardoPaganicurriculo.xml");
		Namexml.add("FabricioMartinscurriculo.xml");
		Namexml.add("Fernandacurriculo.xml");
		Namexml.add("Gleiphcurriculo.xml");
		Namexml.add("Hedercurriculo.xml");
		for (String string : Namexml) {
			File owlfile = new ClassPathResource("static/testFile/" + string).getFile();
			Document xmlfile = ConverterFile.ConverterFileToDocument(owlfile);
			BuscarXmlToPessoa preencherXMLtoOnto = new BuscarXmlToPessoa(xmlfile);
			OntoPessoa pessoa = new OntoPessoa(fixString.corrigirString(preencherXMLtoOnto.NomeCompleto()),
					fixString.corrigirString(preencherXMLtoOnto.IDLattes()),
					fixString.corrigirString(preencherXMLtoOnto.UltimaAtualizacao()));
			preencherXMLtoOnto.buscarXML(pessoa);
			ontoDao.preencherDadosGerais(pessoa);
			ontoDao.preencherProjetoPesquisa(pessoa);
			ontoDao.saveOntologyDAO(new FunctionalSyntaxDocumentFormat());
		}
		long tempoInicio = System.currentTimeMillis();
		File owlfile = new File(System.getProperty("user.dir") + "/" + nomeFile);
		manager = OWLManager.createOWLOntologyManager();
		ontology = manager.loadOntologyFromOntologyDocument(owlfile);
		OWLDataFactory factory = manager.getOWLDataFactory();
		Logger LOG = LoggerFactory.getLogger(ReasonTeste.class);
		ReasonerProgressMonitor progressMonitor = new LoggingReasonerProgressMonitor(LOG, "Loginference");
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasonerFactory rf = new ReasonerFactory();
		OWLReasoner r = rf.createReasoner(ontology, config);
		r.precomputeInferences(InferenceType.OBJECT_PROPERTY_ASSERTIONS);
		OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#", "relacaoProjetoPesquisa");
		OWLClass ce = factory.getOWLClass(DATALATTESIRI + "#", "Pessoa");
		r.getInstances(ce).forEach(u -> u.entities().forEach(i -> {
			System.out.println("@@@@@@" + i.getIRI() + "@@@@@");
			r.objectPropertyValues(i, obj).forEach(y -> {
				System.out.println(y.getIRI());
			});
		}));
		System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));
	}

	// @Test
	// public void DadosGeraisRDF() throws Exception {
	// System.out.println("RDF");
	// long tempoInicio = System.currentTimeMillis();
	// OWLOntologyManager manager;
	// OWLOntology ontology;
	// IRI DATALATTESIRI =
	// IRI.create("http://www.datalattes.com/ontologies/datalattes.owl");
	// File owlfile = new
	// ClassPathResource("static/OWL/datalattesFullRDF.owl").getFile();
	// manager = OWLManager.createOWLOntologyManager();
	// ontology = manager.loadOntologyFromOntologyDocument(owlfile);
	// OWLDataFactory factory = manager.getOWLDataFactory();
	// // this.ontology.classesInSignature().forEach(cls ->
	// // System.out.println(cls.getIRI().getFragment()));
	// // ontology.logicalAxioms().forEach(System.out::println);
	// // ontology.objectPropertiesInSignature().forEach(System.out::println);
	// // OWLObjectProperty obj = factory.getOWLObjectProperty(DATALATTESIRI + "#",
	// // "orientou");
	//
	// // ontology.signature().forEach(System.out::println);
	// OWLReasonerFactory rf = new ReasonerFactory();
	// OWLReasoner r = rf.createReasoner(ontology);
	// r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
	// System.out.println("Tempo Total: " + (System.currentTimeMillis() -
	// tempoInicio));
	// // ontology.classesInSignature().forEach(u -> {
	// // // System.out.println(u.getIRI());
	// //
	// // NodeSet<OWLClass> instances = r.getObjectPropertyDomains(obj);
	// // // NodeSet<OWLNamedIndividual> instances = r.getInstances(u,true);
	// // instances.entities().forEach(i -> {
	// // // System.out.println(i.getIRI());
	// // });
	// // });
	// }
	public static class LoggingReasonerProgressMonitor implements ReasonerProgressMonitor {

		private static final long serialVersionUID = 40000L;
		private static Logger logger;

		public LoggingReasonerProgressMonitor(Logger log) {
			logger = log;
		}

		public LoggingReasonerProgressMonitor(@Nonnull Logger log, String methodName) {
			String loggerName = log.getName() + '.' + methodName;
			logger = LoggerFactory.getLogger(loggerName);
		}

		@Override
		public void reasonerTaskStarted(String taskName) {
			logger.info("Reasoner Task Started: {}.", taskName);
		}

		@Override
		public void reasonerTaskStopped() {
			logger.info("Task stopped.");
		}

		@Override
		public void reasonerTaskProgressChanged(int value, int max) {
			logger.info("Reasoner Task made progress: {}/{}", value, max);
		}

		@Override
		public void reasonerTaskBusy() {
			logger.info("Reasoner Task is busy");
		}
	}
}
