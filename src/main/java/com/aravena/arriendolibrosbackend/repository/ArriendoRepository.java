package com.aravena.arriendolibrosbackend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.Arriendo;

@Repository
public interface ArriendoRepository extends JpaRepository<Arriendo, Integer>  {

	public Arriendo findOneByIdArriendo(Integer idArriendo);
	
	@Transactional
    @Modifying
    @Query("UPDATE Libro l SET l.stockDisponible = stockDisponible-1 WHERE l.idLibro = :idLibro")
	public void restarStockLibro(@Param("idLibro") Integer idLibro);
	
	@Transactional
    @Modifying
    @Query("UPDATE Libro l SET l.stockDisponible = stockDisponible+1 WHERE l.idLibro = :idLibro")
	public void sumarStockLibro(@Param("idLibro") Integer idLibro);
	
	@Modifying
    @Query("UPDATE Arriendo l SET l.estadoArriendo.idEstadoArriendo = :idEstadoArriendo WHERE l.idArriendo = :idArriendo")
	public void actualizaEstadoArriendo(@Param("idArriendo") Integer idArriendo
			                          , @Param("idEstadoArriendo") Integer idEstadoArriendo);
	
	@Query(value = "SELECT INITCAP(L.TITULO) AS TITULO, TO_CHAR(L.FECHA_PUBLICACION, 'DD-MM-YYYY') AS FECHA_PUBLICACION, L.DESCRIPCION, E.NOMBRE AS EDITORIAL, G.NOMBRE AS GENERO, AU.NOMBRE AS AUTOR, I.DESCRIPCION AS IDIOMA, L.CANTIDAD_PAGINAS, L.VALOR_DIARIO, TO_CHAR(A.FECHA_ARRIENDO, 'DD-MM-YYYY') AS FECHA_ARRIENDO, TO_CHAR(A.FECHA_DESDE, 'DD-MM-YYYY') AS FECHA_DESDE, TO_CHAR(A.FECHA_HASTA, 'DD-MM-YYYY') AS FECHA_HASTA, CAST((EXTRACT(DAY FROM AGE(A.FECHA_HASTA,date(A.FECHA_DESDE)))) * L.VALOR_DIARIO AS INTEGER) AS TOTAL, CONCAT(U.NOMBRES, ' ', U.APELLIDOS) AS NOMBRE_USUARIO, U.EMAIL, U.DIRECCION, U.TELEFONO, CAST(EXTRACT(DAY FROM AGE(A.FECHA_HASTA,date(A.FECHA_DESDE))) AS INTEGER) AS DIAS_ARRIENDO, EA.DESCRIPCION AS DESC_ARRIENDO, A.ID_ARRIENDO FROM ARRIENDO A INNER JOIN LIBRO L ON A.ID_LIBRO = L.ID_LIBRO INNER JOIN USUARIO U ON U.ID_USUARIO = A.ID_USUARIO INNER JOIN GENERO G ON L.ID_GENERO = G.ID_GENERO INNER JOIN IDIOMA I ON L.ID_IDIOMA = I.ID_IDIOMA INNER JOIN EDITORIAL E ON L.ID_EDITORIAL = E.ID_EDITORIAL INNER JOIN AUTOR AU ON L.ID_AUTOR = AU.ID_AUTOR INNER JOIN ESTADO_ARRIENDO EA ON EA.ID_ESTADO_ARRIENDO = A.ID_ESTADO_ARRIENDO ORDER BY A.ID_ARRIENDO", nativeQuery = true)
	public List<Object[]> listarTodosArriendos();
	
	@Query(value = "SELECT INITCAP(L.TITULO) AS TITULO, TO_CHAR(L.FECHA_PUBLICACION, 'DD-MM-YYYY') AS FECHA_PUBLICACION, L.DESCRIPCION, E.NOMBRE AS EDITORIAL, G.NOMBRE AS GENERO, AU.NOMBRE AS AUTOR, I.DESCRIPCION AS IDIOMA, L.CANTIDAD_PAGINAS, L.VALOR_DIARIO, TO_CHAR(A.FECHA_ARRIENDO, 'DD-MM-YYYY') AS FECHA_ARRIENDO, TO_CHAR(A.FECHA_DESDE, 'DD-MM-YYYY') AS FECHA_DESDE, TO_CHAR(A.FECHA_HASTA, 'DD-MM-YYYY') AS FECHA_HASTA, CAST((EXTRACT(DAY FROM AGE(A.FECHA_HASTA,date(A.FECHA_DESDE)))) * L.VALOR_DIARIO AS INTEGER) AS TOTAL, CONCAT(U.NOMBRES, ' ', U.APELLIDOS) AS NOMBRE_USUARIO, U.EMAIL, U.DIRECCION, U.TELEFONO, CAST(EXTRACT(DAY FROM AGE(A.FECHA_HASTA,date(A.FECHA_DESDE))) AS INTEGER) AS DIAS_ARRIENDO, EA.DESCRIPCION AS DESC_ARRIENDO, A.ID_ARRIENDO FROM ARRIENDO A INNER JOIN LIBRO L ON A.ID_LIBRO = L.ID_LIBRO INNER JOIN USUARIO U ON U.ID_USUARIO = A.ID_USUARIO INNER JOIN GENERO G ON L.ID_GENERO = G.ID_GENERO INNER JOIN IDIOMA I ON L.ID_IDIOMA = I.ID_IDIOMA INNER JOIN EDITORIAL E ON L.ID_EDITORIAL = E.ID_EDITORIAL INNER JOIN AUTOR AU ON L.ID_AUTOR = AU.ID_AUTOR INNER JOIN ESTADO_ARRIENDO EA ON EA.ID_ESTADO_ARRIENDO = A.ID_ESTADO_ARRIENDO WHERE U.ID_USUARIO = :idUsuario ORDER BY A.ID_ARRIENDO", nativeQuery = true)
	public List<Object[]> listarArriendosPorUsuario(@Param("idUsuario") int idUsuario);
}
