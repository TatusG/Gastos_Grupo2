-- CONSULTAS

DELIMITER $$
CREATE PROCEDURE sp_listarProveedorxDepartamento(p_Nombre_Departamento varchar(50))
BEGIN
    SELECT 
        p.RUC,
        p.RazonSocial,
        p.Direccion,        
        p.Telefono,        
        p.Email        
    FROM 
        Proveedores p
    INNER JOIN 
        Departamentos d ON p.IdDepartamento = d.IdDepartamento    
    WHERE 
       d.Nombre_Departamento = p_Nombre_Departamento;
END; $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_listarProveedorxprovincia(p_provincia varchar(50))
BEGIN
    SELECT 
        p.RUC,
        p.RazonSocial,
        p.Direccion,        
        p.Telefono,        
        p.Email        
    FROM 
        Proveedores p
    INNER JOIN 
        Provincias pr ON p.IdProvincia = pr.IdProvincia
    WHERE 
       pr.Provincia = p_provincia;
END; $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_listarProveedorxdistrito(p_distrito varchar(50))
BEGIN
    SELECT 
        p.RUC,
        p.RazonSocial,
        p.Direccion,        
        p.Telefono,        
        p.Email        
    FROM 
        Proveedores p
    INNER JOIN 
        Distritos d ON p.IdDistrito = d.IdDistrito
    WHERE 
       d.Distrito = p_distrito;
END; $$
DELIMITER ;

call sp_listarProveedorxdistrito();

drop procedure sp_listarProveedorxdistrito;

select p.ruc, p.razonsocial, p.direccion, p.telefono, p.email from proveedores p inner join
departamentos d on p.IdDepartamento = d.IdDepartamento
where d.Nombre_Departamento = "Lima"
