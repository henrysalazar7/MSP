package com.msp.kg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msp.kg.model.TipoVacuna;
import com.msp.kg.repository.ITipoVacunaRepo;

@SpringBootTest
class TipoVacunaTest {

	@Autowired
	private ITipoVacunaRepo repo;

	@Test
	public void crearTest() {
		/*TipoVacuna tipo = new TipoVacuna();
		tipo.setNombre("PFIZER");
		tipo.setDescripcion("Vacuna Pfizer");
		tipo.setEstado("A");
		tipo.setLaboratorio("Pfizer-BioNTech");
		tipo.setNumeroDosis(2);
		tipo.setTiempoEntreDosis(28);
		tipo.setObservacion("Conservación a temperaturas ultrabajas");
		tipo.setTemperaturaMin(-70.0);
		tipo.setTemperaturaMax(-78.5);

		TipoVacuna retorno = repo.save(tipo);
		assertTrue(retorno.getNombre().equals(tipo.getNombre()));

		TipoVacuna tipoSin = new TipoVacuna();
		tipoSin.setNombre("SINOVAC");
		tipoSin.setDescripcion("Vacuna Sinovac");
		tipoSin.setEstado("A");
		tipoSin.setLaboratorio("Sinovac Biotech Ltd");
		tipoSin.setNumeroDosis(2);
		tipoSin.setTiempoEntreDosis(28);
		tipoSin.setTemperaturaMin(2.0);
		tipoSin.setTemperaturaMax(8.0);

		TipoVacuna retornoSin = repo.save(tipoSin);
		assertTrue(retornoSin.getNombre().equals(tipoSin.getNombre()));

		TipoVacuna tipoAz = new TipoVacuna();
		tipoAz.setNombre("ASTRAZENECA");
		tipoAz.setDescripcion("Vacuna AstraZeneca");
		tipoAz.setEstado("A");
		tipoAz.setLaboratorio("Universidad de Oxford");
		tipoAz.setNumeroDosis(2);
		tipoAz.setTiempoEntreDosis(84);
		tipoAz.setTemperaturaMin(2.0);
		tipoAz.setTemperaturaMax(8.0);

		TipoVacuna retornoAz = repo.save(tipoAz);
		assertTrue(retornoAz.getNombre().equals(tipoAz.getNombre()));
*/
		TipoVacuna tipoJoh = new TipoVacuna();
		tipoJoh.setNombre("JOHNSON 1");
		tipoJoh.setDescripcion("Vacuna Johnson & Johnson");
		tipoJoh.setEstado("A");
		tipoJoh.setLaboratorio("Johnson & Johnson");
		tipoJoh.setNumeroDosis(1);
		tipoJoh.setTiempoEntreDosis(0);
		tipoJoh.setTemperaturaMin(2.0);
		tipoJoh.setTemperaturaMax(8.0);

		TipoVacuna retornoJoh = repo.save(tipoJoh);
		assertTrue(retornoJoh.getNombre().equals(tipoJoh.getNombre()));
	}
}
