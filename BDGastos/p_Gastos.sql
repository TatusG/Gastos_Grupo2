DELIMITER $$
CREATE PROCEDURE sp_InsertarGasto(
    IN p_FechaGasto DATE,
    IN p_Documento VARCHAR(50),
    IN p_NumeroDocumento VARCHAR(11),
    IN p_NombreConcepto VARCHAR(200),
    IN p_RazonSocial VARCHAR(100),
    IN p_TipoMoneda VARCHAR(10),
    IN p_Importe DECIMAL(10, 2)
)
BEGIN
    DECLARE v_IdDocumento INT;
    DECLARE v_IdConceptoGasto INT;
    DECLARE v_IdProveedor INT;
    DECLARE v_IdMoneda INT;

    SELECT IdDocumento INTO v_IdDocumento
    FROM TipoDocumento
    WHERE Documento = p_Documento;

    SELECT IdConceptoGasto INTO v_IdConceptoGasto
    FROM ConceptoGasto
    WHERE NombreConcepto = p_NombreConcepto;
    
    SELECT IdProveedor INTO v_IdProveedor
    FROM Proveedores
    WHERE RazonSocial = p_RazonSocial;
    
    SELECT IdMoneda INTO v_IdMoneda
    FROM Moneda
    WHERE TipoMoneda = p_TipoMoneda;
    INSERT INTO Gastos (
        FechaGasto,
        IdDocumento,
        NumeroDocumento,
        Concepto,
        FechaCreacion,
        IdProveedor,
        Moneda,
        Importe
    )
    VALUES (
        p_FechaGasto,
        v_IdDocumento,
        p_NumeroDocumento,
        v_IdConceptoGasto,
        CURDATE(),
        v_IdProveedor,
        v_IdMoneda,
        p_Importe
    );
END $$
DELIMITER ;




-- ---------------------------------------------------------------------------------------------------------------------------------------


drop procedure sp_ActualizarGasto;



DELIMITER $$
CREATE PROCEDURE sp_ActualizarGasto(
	IN p_IdGasto INT,
    IN p_FechaGasto DATE,
    IN p_Documento VARCHAR(50),
    IN p_NumeroDocumento VARCHAR(11),
    IN p_NombreConcepto VARCHAR(200),
    IN p_RazonSocial VARCHAR(100),
    IN p_TipoMoneda VARCHAR(10),
    IN p_Importe DECIMAL(10, 2)
)
BEGIN
    DECLARE v_IdDocumento INT;
    DECLARE v_IdConceptoGasto INT;
    DECLARE v_IdProveedor INT;
    DECLARE v_IdMoneda INT;

    SELECT IdDocumento INTO v_IdDocumento
    FROM TipoDocumento
    WHERE Documento = p_Documento;

    SELECT IdConceptoGasto INTO v_IdConceptoGasto
    FROM ConceptoGasto
    WHERE NombreConcepto = p_NombreConcepto;
    
    SELECT IdProveedor INTO v_IdProveedor
    FROM proveedores
    WHERE RazonSocial = p_RazonSocial;
    
    SELECT IdMoneda INTO v_IdMoneda
    FROM Moneda
    WHERE TipoMoneda = p_TipoMoneda;
    
    UPDATE gastos SET
    FechaGasto = p_FechaGasto,
    IdDocumento = p_Documento,
    NumeroDocumento = p_NumeroDocumento,
    Concepto = v_IdConceptoGasto,
    IdProveedor = v_IdProveedor,
    Moneda = v_IdMoneda,
    Importe = p_Importe;
    
END $$
DELIMITER ;

select * from gastos;


-- ---------------------------------------------------------------------------------------------------------------------------------------






CALL sp_InsertarGasto(
    '2024-09-01',
    'Factura',
    '86789564732',
    'Pantallas',
    'Compupalace',
    'Soles',
    200.00
);

call sp_listarGastos;

DELIMITER $$
CREATE PROCEDURE sp_listarGastos()
BEGIN
    SELECT 
        g.FechaGasto,
        td.Documento AS TipoDocumento,
        g.NumeroDocumento,
        p.RazonSocial AS Proveedor,
        c.NombreConcepto,
        m.TipoMoneda,
        g.Importe
    FROM 
        gastos g
    INNER JOIN 
        proveedores p ON g.IdProveedor = p.IdProveedor
    INNER JOIN 
        tipodocumento td ON g.IdDocumento = td.IdDocumento
	INNER JOIN
		conceptogasto c ON g.Concepto = c.IdConceptoGasto
	INNER JOIN
		moneda m ON g.Moneda = m.IdMoneda
    where g.IdEliminado=0;
end; $$
DELIMITER ;




-- ---------------------------------------------------------------------------------------------------------------------------------------





DELIMITER $$
create procedure sp_eliminarGastos(p_IdGasto int)
begin
	Update gastos
	set idEliminado=1
	where IdGasto = p_IdGasto;
end; $$
DELIMITER ;



-- ---------------------------------------------------------------------------------------------------------------------------------------



DELIMITER $$
create procedure sp_buscarGasto(p_IdGasto int)
Begin
	SELECT 
        g.FechaGasto,
        td.Documento AS TipoDocumento,
        g.NumeroDocumento,
        p.RazonSocial AS Proveedor,
        c.NombreConcepto,
        m.TipoMoneda,
        g.Importe
    FROM 
        gastos g
    INNER JOIN 
        proveedores p ON g.IdProveedor = p.IdProveedor
    INNER JOIN 
        tipodocumento td ON g.IdDocumento = td.IdDocumento
	INNER JOIN
		conceptogasto c ON g.Concepto = c.IdConceptoGasto
	INNER JOIN
		moneda m ON g.Moneda = m.IdMoneda
    where g.IdEliminado=0;
end; $$
DELIMITER ;



-- ---------------------------------------------------------------------------------------------------------------------------------------

call sp_listarGastosConFiltros('Compupalace',null);
drop procedure sp_listarGastosConFiltros;

DELIMITER $$
CREATE PROCEDURE sp_listarGastosConFiltros(
    IN p_RazonSocial VARCHAR(100),
    IN p_NombreConcepto VARCHAR(200)
)
BEGIN
    SELECT 
        g.FechaGasto,
        td.Documento AS TipoDocumento,
        g.NumeroDocumento,
        p.RazonSocial AS Proveedor,
        c.NombreConcepto,
        m.TipoMoneda,
        g.Importe
    FROM 
        gastos g
    INNER JOIN 
        proveedores p ON g.IdProveedor = p.IdProveedor
    INNER JOIN 
        tipodocumento td ON g.IdDocumento = td.IdDocumento
    INNER JOIN
        conceptogasto c ON g.Concepto = c.IdConceptoGasto
    INNER JOIN
        moneda m ON g.Moneda = m.IdMoneda
    WHERE 
        g.IdEliminado = 0
        AND (p_RazonSocial IS NULL OR p.RazonSocial LIKE CONCAT('%', p_RazonSocial, '%'))
        AND (p_NombreConcepto IS NULL OR c.NombreConcepto LIKE CONCAT('%', p_NombreConcepto, '%'));
END $$
DELIMITER ;

