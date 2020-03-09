package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.PlaceInfo;

@Repository
public interface PlaceRepository extends CrudRepository<PlaceInfo, Integer> {

	@Query(value = "SELECT public.\"getSimilarPlaces\"(\n" +
					"\t:popStart, \n" +
					"\t:popEnd, \n" +
					"\t:typeId, \n" +
					"\t:carbonStart, \n" +
					"\t:carbonEnd, \n" +
					"\t:perCapCarbStart, \n" +
					"\t:perCapCarbEnd, \n" +
					"\t:popDensityStart, \n" +
					"\t:popDensityEnd\n" +
					");", nativeQuery = true)
	public String getSimilarPlaces(@Param("popStart") double popStart, @Param("popEnd") double popEnd,
																 @Param("typeId") int typeId,
																 @Param("carbonStart") double carbonStart, @Param("carbonEnd") double carbonEnd,
																 @Param("perCapCarbStart") double perCapCarbStart, @Param("perCapCarbEnd") double perCapCarbEnd,
																 @Param("popDensityStart") double popDensityStart, @Param("popDensityEnd") double popDensityEnd);

  /**
   * Queries the database and finds the nearest place to the given latitude and longitude
   * by elucidaian distance.
   * @param latitude the latitude to search near
   * @param longitude the longitude to search near
   * @return geoJSON string representing the found place
   */
	@Query(value = "SELECT cast(row_to_json(fc) as character varying)\n"
      + " FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features\n"
      + "FROM (SELECT 'Feature' As type,\n"
      + "       ST_AsGeoJSON(place.point)\\:\\:json As geometry,\n"
      + "       row_to_json((SELECT l FROM (SELECT place.place_id, type.type_name, population, carbon, percapcarb, popdensity, biomass, coal,\n"
      + "       cogeneration, gas, geothermal, hydro, nuclear, oil, other, petcoke, solar, storage,\n"
      + "       waste, wave_and_tidal, wind, n.name, n_0.name as \"nation_name\", n_1.name  as \"state_name\", n_2.name  as \"county_name\") As l\n"
      + "        )) As properties\n"
      + " FROM public.\"PLACE_INFO\" as place \n"
      + "JOIN public.\"NAME_PLACE\" as np ON place.place_id = np.place_id\n"
      + "JOIN public.\"NAME\" as n ON np.name_id = n.name_id\n"

      + "LEFT JOIN public.\"NAME_PLACE\" as np_0 ON place.gadm_0_id = np_0.place_id\n"
      + "LEFT JOIN public.\"NAME\" as n_0 on np_0.name_id = n_0.name_id\n"

      + "LEFT JOIN public.\"NAME_PLACE\" as np_1 ON place.gadm_1_id = np_1.place_id \n"
      + "LEFT JOIN public.\"NAME\" as n_1 ON np_1.name_id = n_1.name_id\n"

      + "LEFT JOIN public.\"NAME_PLACE\" as np_2 ON place.gadm_2_id = np_2.place_id \n"
      + "LEFT JOIN public.\"NAME\" as n_2 ON np_2.name_id = n_2.name_id\n"

      + "LEFT JOIN public.\"TYPE\" as type ON place.type_id = type.type_id\n"

      + "ORDER BY point <-> ST_SetSRID( ST_Point(:longitude, :latitude), 4326)\\:\\:geometry \n"
      + "LIMIT 1\n"
      + ") As f \n"
      + ") As fc;", nativeQuery = true)
	String getNearestPlace(@Param("latitude") double latitude, @Param("longitude") double longitude);
}
