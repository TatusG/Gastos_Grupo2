use gastos_grupo2;

CREATE VIEW v_detalle_usuario AS
SELECT
u.IdUsuario,
u.Usuario,
concat(u.Nombres, ' ', u.ApellidoPaterno, ' ', u.ApellidoMaterno) AS NombreCompleto,
p.Perfil as Perfil,
e.Estado as Estado,
u.FechaCreacion,
uc.Usuario as Creadopor,
u.FechaModificacion,
um.Usuario as ModificadoPor,
u.IdEliminado
FROM
usuario u
LEFT JOIN Perfil p ON u.IdPerfil = p.IdPerfil
LEFT JOIN Estado e ON u.IdEstado = e.IdEstado
LEFT JOIN Usuario uc ON u.UsuarioCreacion = uc.IdUsuario
LEFT JOIN Usuario um ON u.UsuarioModificacion = um.IdUsuario
ORDER BY
u.FechaCreacion DESC;

select * from v_detalle_usuario;

select * from usuario;

CREATE VIEW v_detalle_proveedores AS
SELECT
    p.IdProveedor,
    p.RUC,
    p.RazonSocial,
    p.Direccion,
    d.Nombre_Departamento AS Departamento,
    pr.Provincia AS Provincia,
    di.Distrito AS Distrito,
    e.Estado AS Estado,
    uc.Usuario AS Creadopor,
    p.FechaCreacion,
    p.FechaModificacion,
    um.Usuario AS ModificadoPor,
    p.IdEliminado
FROM
    Proveedores p
INNER JOIN Departamentos d ON p.IdDepartamento = d.IdDepartamento
INNER JOIN Provincias pr ON p.IdProvincia = pr.IdProvincia
INNER JOIN Distritos di ON p.IdDistrito = di.IdDistrito
INNER JOIN Estado e ON p.IdEstado = e.IdEstado
INNER JOIN Usuario uc ON p.UsuarioCreacion = uc.IdUsuario
LEFT JOIN Usuario um ON p.UsuarioModificacion = um.IdUsuario
ORDER BY
    p.IdProveedor;

select * from v_detalle_proveedores;
