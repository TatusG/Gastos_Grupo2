-- Usuario

DELIMITER $$
create procedure sp_InsertarUsuario (
p_perfil varchar(20), 
p_estado varchar(11), 
p_usuario varchar(45), 
p_contraseña varchar(64), 
p_apellidopa varchar(50), 
p_apellidoma varchar(50), 
p_nombres varchar(50), 
p_Foto blob,
p_usuariocrea varchar(45))
begin
    declare e_IdEstado int;
    declare pe_IdPerfil int;
    declare us_IdUsuario int;
    select IdEstado into e_IdEstado from Estado
    where Estado = p_estado
    limit 1;
    select IdPerfil into pe_IdPerfil from Perfil
    where Perfil = p_perfil
    limit 1;
    select IdUsuario into us_IdUsuario from Usuario
    where Usuario = p_usuariocrea    
    limit 1;
	Insert INTO usuario (
    IdPerfil, 
    IdEstado, 
    Usuario, 
    contraseña, 
    ApellidoPaterno, 
    ApellidoMaterno, 
    Nombres, 
    Foto, 
    FechaCreacion,
    UsuarioCreacion)
    values (
    pe_IdPerfil, 
    e_IdEstado,  
    p_usuario, 
    sha2(p_contraseña,256), 
    p_apellidopa, 
    p_apellidoma, 
    p_nombres, 
    p_Foto, 
    curdate(),
    us_IdUsuario);    
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarUsuario()
Begin
	select 
    u.IdUsuario,
    p.Perfil,
    e.estado,
    u.usuario,
    u.contraseña,
    u.ApellidoPaterno,
    u.ApellidoMaterno,
    u.Nombres,
    u.Foto
    FROM 
    usuario u
    INNER JOIN 
		Perfil p ON p.IdPerfil = u.IdPerfil
	INNER JOIN
		estado e ON e.IdEstado = u.IdEstado    
    where idEliminado=0
    order by 1 asc;
end; $$
DELIMITER ;

drop procedure sp_listarUsuario;
call sp_listarUsuario;

DELIMITER $$
create procedure sp_buscarUsuario(p_IdUsuario int)
Begin
	select 
    u.IdUsuario,
    p.Perfil,
    e.Estado,
    u.Usuario,
    u.contraseña,
    u.ApellidoPaterno,
    u.ApellidoMaterno,
    u.Nombres,
    u.Foto
    FROM 
        usuario u
    INNER JOIN 
		perfil p ON p.IdPerfil = u.IdPerfil
	INNER JOIN
		estado e ON e.IdEstado = u.IdEstado
    where IdUsuario = p_IdUsuario
    and idEliminado=0;
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_actualizarusuario (
p_IdUsuario int, 
p_perfil varchar(20), 
p_estado varchar(11), 
p_usuario varchar(45), 
p_contraseña varchar(64), 
p_apellidopa varchar(50), 
p_apellidoma varchar(50), 
p_nombres varchar(50), 
p_Foto blob,
p_usuariomod varchar(45))
begin
	declare e_IdEstado int;
    declare pe_IdPerfil int;   
    declare us_IdUsuario int; 
    select IdEstado into e_IdEstado from Estado
    where Estado = p_estado
    limit 1;
    select IdPerfil into pe_IdPerfil from Perfil
    where Perfil = p_perfil
    limit 1;    
    select IdUsuario into us_IdUsuario from Usuario
    where Usuario = p_usuariomod
    limit 1;
	UPDATE usuario SET 
    IdPerfil = pe_IdPerfil, 
    IdEstado= e_IdEstado, 
    Usuario = p_usuario, 
    contraseña = IF(p_contraseña IS NOT NULL AND p_contraseña !='', sha2(p_contraseña,256), contraseña), 
    ApellidoPaterno = p_apellidopa, 
    ApellidoMaterno = p_apellidoma, 
    Nombres = p_nombres, 
    Foto = IF(p_Foto IS NOT NULL, p_Foto, Foto),  
    FechaModificacion=curdate(),
    UsuarioModificacion = us_IdUsuario
    WHERE IdUsuario = p_IdUsuario;
end; $$
DELIMITER ;


DELIMITER $$
create procedure sp_eliminarusuario (p_IdUsuario int)
begin
	update usuario
    set idEliminado=1
    where IdUsuario = p_IdUsuario;
end; $$
DELIMITER ;

DELIMITER $$
create procedure sp_listarPerfil ()
begin
	select *
    from Perfil;    
end; $$
DELIMITER ;

call sp_listarUsuario;

call sp_listarPerfil;

select * from usuario;

-- Administrador - Operador

select p.Perfil from perfil p inner join usuario u on p.IdPerfil = u.IdPerfil where Usuario = "Tatiana" AND contraseña = sha2('1234567',256) AND IdEliminado = 0;

SELECT Perfil p FROM usuario WHERE Usuario = 1 AND contraseña = sha2('1234567',256) AND IdEliminado = 0;

select * from usuario;

select count(*) from usuario where Usuario="KRS3476";

drop procedure sp_InsertarUsuario;



-- Usuarios
-- Tatiana / 123456 - Administrador
-- Jiussepe / 67589%% - Administrador
-- Carlos / CT6720 - Administrador
-- TomasM / 7891234 - Operador
-- PabloTH / &iu89$ - Administrador