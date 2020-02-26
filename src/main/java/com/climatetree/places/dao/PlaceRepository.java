package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.PlaceInfo;

@Repository
public interface PlaceRepository extends CrudRepository<PlaceInfo, Integer> {
	
	/**
	 * Queries the database for PlaceInfo entries that are within the following range:
	 *  - Population is greater than popStart
	 *  - Population is less than popEnd
	 * 
	 * @param popStart start of the population range
	 * @param popEnd end of the population range
   * @param typeId the type id ( 1 = state, 2 = nation , 3 = county, 4 = urbanextent)
	 * @return a list of PlaceInfo objects
	 */
	@Query(value = "SELECT cast(row_to_json(fc) as character varying)\n"
					+ " FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features\n"
					+ "	 	FROM (SELECT 'Feature' As type,\n"
					+ "  		  ST_AsGeoJSON(place.point)\\:\\:json As geometry,\n"
					+ "  		  row_to_json((SELECT l FROM (SELECT place.place_id, type.type_name, population, carbon, percapcarb, popdensity, biomass, coal,\n"
					+ "						cogeneration, gas, geothermal, hydro, nuclear, oil, other, petcoke, solar, storage,\n"
					+ "						 waste, wave_and_tidal, wind, n.name, n_0.name as \"nation_name\", n_1.name  as \"state_name\", n_2.name  as \"county_name\") As l\n" + "  		    )) As properties\n"
					+ "  		 FROM public.\"PLACE_INFO\" as place \n" + "			JOIN public.\"NAME_PLACE\" as np\n"
					+ "	     		ON place.place_id = np.place_id\n" + "	   		JOIN public.\"NAME\" as n\n"
					+ "	   		ON np.name_id = n.name_id\n"

					+		"LEFT JOIN public.\"NAME_PLACE\" as np_0\n"
					+		"on place.gadm_0_id = np_0.place_id JOIN public.\"NAME\" as n_0 on np_0.name_id = n_0.name_id\n"

					+		"LEFT JOIN public.\"NAME_PLACE\" as np_1\n"
					+		"on place.gadm_1_id = np_1.place_id left JOIN public.\"NAME\" as n_1 on np_1.name_id = n_1.name_id\n"

					+		"LEFT JOIN public.\"NAME_PLACE\" as np_2\n"
					+		"on place.gadm_2_id = np_2.place_id left JOIN public.\"NAME\" as n_2 on np_2.name_id = n_2.name_id\n"
					+ 	"LEFT JOIN public.\"TYPE\" as type\n"
					+		"on place.type_id = type.type_id\n"
					+		"WHERE place.population>=:popStart AND place.population<=:popEnd AND place.type_id=:typeId) As f \n"
					+ "	   ) As fc;", nativeQuery = true)
	public String getSimilarPlaces(@Param("popStart") double popStart,
											@Param("popEnd") double popEnd,@Param("typeId") int typeId);
}
