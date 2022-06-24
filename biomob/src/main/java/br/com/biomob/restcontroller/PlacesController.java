package br.com.biomob.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.Locais;
import br.com.biomob.interfaces.IBiomobPlacesService;
import br.com.biomob.model.BiomobPlacesReturn;
import br.com.biomob.model.Page;
import br.com.biomob.repository.BiomobRepository;

@CrossOrigin
@RestController
public class PlacesController {
	
	@Autowired
	private BiomobRepository biomobRepository;
	
	@Autowired
	IBiomobPlacesService iBiomobPlacesService;
	
	@GetMapping("/places/{category}/{latitude}/{longitude}/{range}")
	public BiomobPlacesReturn findPlaces(@PathVariable String category, @PathVariable String latitude, @PathVariable String longitude, @PathVariable String range) {
		return iBiomobPlacesService.findPlacesByGeoreference(category, latitude, longitude, range);
	}
	
	@PostMapping("/places/next-page")
	public BiomobPlacesReturn nextPage(@RequestBody Page page) {
		return iBiomobPlacesService.nextPage(page.getActualPageUrl(), page.getNextPageToken());
	}
	
	@GetMapping("/apagar/{placeId}")
	public Optional<Locais> apagar(@PathVariable String placeId) {
		return biomobRepository.findById(placeId);
	}
	
}
