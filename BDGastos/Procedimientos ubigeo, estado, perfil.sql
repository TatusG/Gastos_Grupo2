
DELIMITER $$
create procedure sp_listarDepartamento ()
begin
	select *
    from Departamentos;
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarProvincias (p_nombreDepartamento varchar(50))
begin
	select *
    from Provincias
    where IdDepartamento=(
		select IdDepartamento
        from Departamentos
        where Nombre_Departamento=p_nombreDepartamento
        LIMIT 1);
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarDistritos (p_nombreProvincia varchar(50))
begin
	select *
    from Distritos
    where IdProvincia=(
		select IdProvincia
        from Provincias
        where Provincia=p_nombreProvincia
        LIMIT 1);
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarEstado ()
begin
	select *
    from Estado;    
end; $$
DELIMITER ;

call sp_listarProvincias ('ANCASH');

call sp_listarDistritos ('asuncion');

select * from distritos where idProvincia = 204;

SELECT Provincia, COUNT(*)
FROM Provincias
GROUP BY Provincia
HAVING COUNT(*) > 1;

