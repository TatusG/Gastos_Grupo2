-- Proveedor

DELIMITER $$
CREATE PROCEDURE sp_listarProveedor()
BEGIN
    SELECT 
		p.IdProveedor,
        p.RUC,
        p.RazonSocial,
        p.Direccion,
        d.Nombre_Departamento AS Departamento,
        pr.Provincia AS Provincia,
        di.Distrito AS Distrito,
        p.Telefono,
        p.Celular,
        p.Email,
        e.Estado AS Estado
    FROM 
        Proveedores p
    INNER JOIN 
        Departamentos d ON p.IdDepartamento = d.IdDepartamento
    INNER JOIN 
        Provincias pr ON p.IdProvincia = pr.IdProvincia
    INNER JOIN 
        Distritos di ON p.IdDistrito = di.IdDistrito
    INNER JOIN 
        Estado e ON p.IdEstado = e.IdEstado
    WHERE 
        p.IdEliminado = 0
    ORDER BY 
        p.IdProveedor ASC;
END; $$
DELIMITER ;

DELIMITER $$
create procedure sp_InsertarProveedor (
p_ruc varchar(11), 
p_razonsocial varchar(100), 
p_direccion varchar(255), 
p_departamento varchar(50), 
p_provincia varchar(50), 
p_distrito varchar(50), 
p_telefono varchar(8), 
p_celular varchar(9), 
p_email varchar(50), 
p_estado varchar(11), 
p_usuariocrea varchar(45))
begin
	declare u_IdDepartamento int;
    declare u_IdProvincia int;
    declare u_IdDistrito int;
    declare e_IdEstado int;
    declare us_IdUsuario int;    
    select IdDepartamento into u_IdDepartamento from Departamentos
    where Nombre_Departamento = p_departamento
    limit 1;
    select IdProvincia into u_IdProvincia from Provincias
    where Provincia = p_provincia
    and IdDepartamento = u_IdDepartamento
    limit 1;
    select IdDistrito into u_IdDistrito from Distritos
    where Distrito = p_distrito
    and IdProvincia = u_IdProvincia
    limit 1;
    select IdEstado into e_IdEstado from Estado
    where Estado = p_estado
    limit 1;
    select IdUsuario into us_IdUsuario from Usuario
    where Usuario = p_usuariocrea
    limit 1;
	Insert INTO Proveedores (
    RUC, 
    RazonSocial, 
    Direccion, 
    IdDepartamento, 
    IdProvincia, 
    IdDistrito, 
    Telefono, 
    Celular, 
    Email, 
    IdEstado, 
    FechaCreacion, 
    UsuarioCreacion)
    values (
    p_ruc, 
    p_razonsocial, 
    p_direccion, 
    u_IdDepartamento,
    u_IdProvincia,
    u_IdDistrito, 
    p_telefono, 
    p_celular, 
    p_email, 
    e_IdEstado, 
    curdate(), 
    us_IdUsuario);
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_actualizarproveedor (
p_IdProveedor int, 
p_ruc varchar(11), 
p_razonsocial varchar(100), 
p_direccion varchar(255), 
p_departamento varchar(50), 
p_provincia varchar(50), 
p_distrito varchar(50), 
p_telefono varchar(8), 
p_celular varchar(9), 
p_email varchar(50), 
p_estado varchar(11),
p_usuariomod varchar(45))
begin
	declare u_IdDepartamento int;
    declare u_IdProvincia int;
    declare u_IdDistrito int;
    declare e_IdEstado int;
    declare us_IdUsuario int;    
    select IdDepartamento into u_IdDepartamento from Departamentos
    where Nombre_Departamento = p_departamento
    limit 1;
    select IdProvincia into u_IdProvincia from Provincias
    where Provincia = p_provincia
    and IdDepartamento = u_IdDepartamento
    limit 1;
    select IdDistrito into u_IdDistrito from Distritos
    where Distrito = p_distrito
    and IdProvincia = u_IdProvincia
    limit 1;
    select IdEstado into e_IdEstado from Estado
    where Estado = p_estado
    limit 1;
    select IdUsuario into us_IdUsuario from Usuario
    where Usuario = p_usuariomod
    limit 1;
	UPDATE Proveedores SET
    IdProveedor=p_IdProveedor,
    RUC=p_ruc,
    RazonSocial= p_razonsocial, 
    Direccion=p_direccion, 
    IdDepartamento=u_IdDepartamento, 
    IdProvincia=u_IdProvincia, 
    IdDistrito=u_IdDistrito, 
    Telefono=p_telefono, 
    Celular=p_celular, 
    Email=p_email, 
    IdEstado=e_IdEstado, 
    FechaModificacion=curdate(), 
    UsuarioModificacion = us_IdUsuario
    WHERE IdProveedor = p_Idproveedor;
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_eliminarProveedor (p_RUC varchar(11))
begin
	update Proveedores
    set idEliminado=1
    where RUC = p_RUC;
end; $$
DELIMITER ;

DELIMITER $$ -- Modificado
create procedure sp_buscarProveedor(p_RUC VARCHAR(11))
Begin
	SELECT 
		p.IdProveedor,
        p.RUC,
        p.RazonSocial,
        p.Direccion,
        d.Nombre_Departamento AS Departamento,
        pr.Provincia AS Provincia,
        di.Distrito AS Distrito,
        p.Telefono,
        p.Celular,
        p.Email,
        e.Estado AS Estado
    FROM 
        Proveedores p
    INNER JOIN 
        Departamentos d ON p.IdDepartamento = d.IdDepartamento
    INNER JOIN 
        Provincias pr ON p.IdProvincia = pr.IdProvincia
    INNER JOIN 
        Distritos di ON p.IdDistrito = di.IdDistrito
    INNER JOIN 
        Estado e ON p.IdEstado = e.Idestado
    where RUC = p_RUC
    and idEliminado=0;
end; $$
DELIMITER ;

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
        where Nombre_Departamento=p_nombreDepartamento);
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarDistritos (p_nombreDistrito varchar(50))
begin
	select *
    from Distritos
    where IdProvincia=(
		select IdProvincia
        from Distritos
        where Distrito=p_nombreDistrito);
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarEstado ()
begin
	select *
    from Estado;    
end; $$
DELIMITER ;

call sp_listarProveedor;

select * from Proveedores;