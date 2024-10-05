-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: gastos_grupo2
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `IdUsuario` int NOT NULL AUTO_INCREMENT,
  `IdPerfil` int DEFAULT NULL,
  `IdEstado` int DEFAULT NULL,
  `Usuario` varchar(45) NOT NULL,
  `contraseÃ±a` varchar(64) DEFAULT NULL,
  `ApellidoPaterno` varchar(50) NOT NULL,
  `ApellidoMaterno` varchar(50) DEFAULT NULL,
  `Nombres` varchar(50) DEFAULT NULL,
  `Foto` blob,
  `FechaCreacion` date DEFAULT NULL,
  `UsuarioCreacion` int DEFAULT NULL,
  `FechaModificacion` date DEFAULT NULL,
  `UsuarioModificacion` int DEFAULT NULL,
  `IdEliminado` int DEFAULT '0',
  PRIMARY KEY (`IdUsuario`),
  UNIQUE KEY `Usuario` (`Usuario`),
  KEY `IdPerfil` (`IdPerfil`),
  KEY `IdEstado` (`IdEstado`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IdPerfil`) REFERENCES `perfil` (`IdPerfil`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`IdEstado`) REFERENCES `estado` (`IdEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,1,'Tatiana','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Grados','VÃ©rtiz','Tatiana',NULL,'2024-09-22',1,'2024-10-02',NULL,0),(2,1,1,'Carlos','0f79bb683d2be820b15d6a8285fbddcf03f968010c92c63a60634ec439b9b409','Dominguez','Talavera','Carlos Martin',NULL,'2024-09-24',NULL,'2024-10-01',NULL,0),(3,2,2,'TomasM','23b403b3f1224fd8f5956bddf8a600ff81812904e3fefe8d6e2c25f02479ff91','Garcia','Mendoza','Tomas',NULL,'2024-09-24',NULL,'2024-10-01',NULL,0),(4,2,1,'CarlosPV','fe88e8f1809ca547724e958e9a350f3cb608c43882c94004e6d4fabc1d01f4a9','Paredes','Vasquez','Carlos',NULL,'2024-09-29',NULL,'2024-10-01',NULL,0),(5,2,1,'PGV3476','5b2a81960f9a779b2b50ed87c760cff062ea048e5f7540105b63b1d508ccad24','Consuelo','Vargas','Maria',NULL,'2024-09-30',1,'2024-10-01',NULL,0),(6,2,2,'KLopez6','8bb0cf6eb9b17d0f7d22b456f121257dc1254e1f01665370476383ea776df414','Gonzales','Lopez','Karla',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0@\0\0\0@\0\0\0ªiq\Þ\0\0\0sBIT|dˆ\0\0\0	pHYs\0\0\Ä\0\0\Ä•+\0\0eIDATxœÅ›{U\Ç?Ý·o÷\íûœL2\Îd2y\'$’!!@\"A,EWpuwñK+[[e­U[[¥n•+,\ÔZEm\í®@E„rKEˆ+Qp‘‡’ $\äE˜\Ì$ó~\ÞgwŸsöî¾·\ï\Ì\ÜfnôWuª÷\Ñ\çûý=\Î\ïü\Îi¿€\Üÿý€º®¿»{÷\î\á¿DB\Ñþœ»\çž{\ìõ\ë7\ì[¹jå¹\\–r©¬Ž=r\â¾û\îsŽ;\Ö755õ\Ûþþþÿ\Îü¹út1h_¹r\å-Ë–-ÛžN§W˜¦i\n!¨T*S\Éd2½u\ë¶]—n\Ø@ww7–i¢\Çb\n}\äž~ú)&\'\'¾¾¾»GFF\î\ÔE\è_4“€•Û¶mû·\åË—¾££#n†a‹\Å\0p\Çq¨T*LNN\â8.;v\î\à\Ö[oC\×u\Ç\á™g~\É\Ïö\î\Åqzzz~044ô\Õ&öoV‰5\ãOººº¾²cÇŽ\'W®\\ÙL&cš¦6\0)%ž\çU›R\nPœ8q‚_=óK—/\'7Y´¨ññqÎ;K*•\ê\Î\çó\ï8ŽóN3ú\ØH\æMÀŠ+\îÚ´i\Ów3™Œ\r ”BJ‰\ÏóªG\Ïóp]\Ïó¨T*¼ô\â~:—,Á´,\Ú\Û\Û9xð\0RJ€\ã\ã\ã÷Î·\ç}>?^²d\É7.¹\ä’oš¦‰mÛ´´´\ÍfI&“†Q%C)…RªxHˆ€ø>…BT:MW\×R\02™\Ìz\àªùA<¿óøm\×\êÕ«¿\Ó\ÖÖ†”’‘‘z{{QJõÿ\Ð*”R\èº^µŠ\é$¸Ž\Ã/Ÿ~Š\Ï\áoH¥’~\çƒ…\î\Zy£9pgÊœ	X¶l\Ù\í–eYÇ¯\Ò5X˜\Ë\ÓN±L¡\â’\Íf‰\ÅbH)«\î „˜q-„\àõ\×^\åÆ›n¢···úË²66i™3…Ba»›\ã“\Û6\Ð}\éj6¯_\ÍÒŽvt](\ÅT¾Àë‡ð\Üäµ£=\ÄM«\n6ªý°\éºÎ½ÿý_@\Ímb±XG³À\Î&s&\àño)vÝ®ƒó›M­F@&“\á¦k®\ä¦\í›y\í\Ð¾¹\ç\çx\Ä\ê,`z ½½=ú¨¦ŒTd\ÎApý\Êå‹«\àõ\è\èñiG£úùÕ›\Öó\ï»?G©X˜¡ù(!®\ë\"¥¬Z\0PiÜ™2g+±\Ü\×x„„Xbqˆ~›fW]¾–\Ï]³~V\àa\ÓuR©T%Áó¼s\Í<]\æDÀþ½\Þ\Ð\ãV;š˜½!!°\0-\n^ósN¯\Ì\ßÿ\ÕGq\Ê\ÅY­@¦iT*•\êhQ©TN6sÌ‰\0w8þ\ÓN\é\0C\Ç?-\" ¥ši+pË ­\Ù×®_Zg‹¡\äóùCM\Â:«Ì‰€˜&\Ú\âV¢þ¦(Jú\Çp#]pJþ}\nØ¾~iCBTµ_*•p\ç÷óøA2§Q@\ÓTKÜ²üE\r8\Z\È\àK\Â§^¥FJ\Ð6­\ê\Äq4M«\æÑ¼ ¼_©TNý\Í\0\ÚH\æD€•kÉ h\n±©ù\×Rø\à…Jø\×JÖ‘°¢½•J¥B<ŸA€\çy\èºðrs\áÎ”¹¹@ÜŠ\áU|¿vJP\ÎCiŠcP\ÉûZ—®O„I‰´¤¸®Ëš¤¹\ç\Ë7ó‰+V\Ö%Ha\æ˜\Ï\çŸo6\à\é2\ÇD\ÈC\Æ\Ð\Â!¯\Zíƒˆ5­‡H’%%HIg‹\Ícÿò·\Ø	›O]¿\ç¿ø-¦\\Q/”\Ëe\Ê\åò‹MC\Ú@\ædùñ±IŒç›ºð@z5­×¿®\Þ÷¿¯\"\îÿ\Úm\ØqU\Éc\è\Z3	„†APA:ô5\ï™›x8¥¦@#‚a*¬€ðž’>h\á¡Dp”‚+\×,A	%%•r‘÷\Æð<I6›EJ‰\ã8ÿ\×<˜eNt´öŸÈ{,\Ë ^«\Î\0¥PuD,@\Ô,M\ã¹7Þ¡\âúÚ\Ç\ã!(—\ËuøeN.pù\ï8N¹ø–ò<Œ\çú\Ú.\ÊsüV½v#Ÿ{ðž\ïB†ÅžÿÝ¢ª}!¥R\é\Í;›\Ìy.Pšœx9(Ã£\ç =7hN\í³*ø	\Âˆ¯9\ÍþC\'\Éd2\èº\îG\\\àý\æÁl,s&\à\\\ßû¿N¥^Ëž‹Žß¢÷¼\0¼!Az(%¹\ë\'Ï’L&±m»®~Œ7fc™s=À3‹ûÇ‡‡F´µµjºŽ\Ò44´ú€Ä‚\ê0X‹/¿ý¯ž$“\ÉÔ¥ÀAAô¢\ÖB™³\ìºó%oblô\'Q¢fþ¡[„\ÖPs%Ž\ëñ›ƒ\'I¥R3¦Ç,m\ÄóË¼ª\Â}§O\ß[˜œ¡¿W`\Äüe„Ÿ£bŒö!i\Æ\ZN†t]ÿh³@žO\æEÀÿ¹ÿÝ‘ÁÁGT$\è…DÈ ÕJ\á\Äl\Þû ™¤\Å\Æ%¹†3B\Ã0þ®Y \Ï\'ó\"\0 ¿·ÿcc“*jþuCŸ\ï	J˜œ>|€”e`\Ú6\×]º˜-K²\n#W;›€ñ¼2\ï@ó\ÃWON\Þ\Þ\Ýy\"´¿`\èh3\æ\0†…–Y\Ä\èð0g!\×\Èf3X)›˜[»ˆC•…ô÷÷\ãy\Þô‚\Èf\àA.\â\"iS\"\í/½û\Î\í[ºz\Ìdò3V2£a˜`¥\Ð\Òm8®GÏ‘?29<DÊŠ‘Œ$s-\Ä%%£%Áqm	«W¯!iÛœ9s¦J\0Ð©”J\0mV\Ø|ðÁU»nÿVQ\Z«Oþ\áe¤ð(LMq\îý÷\è;s†Š”e4\r¬dŠD&€’‚w†‡Gul;Á\Ýw\ßÅ’®.:D±XW•®UJõ\0o5£¯\Óe>Kc\ìÝ»7–\Ë\åþi\ãÆ\ßnkkK{\Ó#N\É$L\ÒVœT\Â\"i\ê¤3aa¦²è†ô$š¦óî¸†‚ŽŽvÒ©4w\Üq7\Üpw\ßuûö\í\Ðt]@Ji{š‚:\"s¶€‡~xë¥—n\Øw\ÅW|)N›\0c=\Ç;u˜T\Â$°H\'\â¤,ƒ”\ÇJ&1S\ÌdÊ¯J\É\ÄT§Ïš8R±s\Ç–.]Š®\ë\är-|ü\æ›Y³f\r\Þ|“B¡ kšöi¥\Ô\àj…·yË‡\î¹\çû…^øv\ízu\íÚµ[¢žš¤l›T\"AÊ¶H%LR	‹D*™\ÎúÚ›\ÕY\ã[CG7I¥\Ól\é\î&nÆ‰\é1R?õ©[xt\ï\ÏØµkš¦¡\ëú?jšöpE³øPðð\ÃoÝ¾}ûó—]~ù-v\"¡A°\ÒPÀd\Ï\Êý\'I\'\â¤&™„‰Lb¥3Ä“Y\Óò§\ÇJP,–x²Ç ¢›\\\Ù\ÝÍ¦QJ!d}B”\Íf¹\îº\ë1\Í8D)Õ¡i\ÚW”R]À!`ò\ÏBÀO<ñ¥+·n}¢³³³]‹=T0@)¥(œ9†9M:pd2‰•\Îb¦³\Ä,\r^ ¤\ä\Õ÷&9\ê\ä0\ãqn½õ³X–€—U\\\×\Åqr\Ù,kÖ®cÅŠ¼ñ\Æ\ë8Ž£\ëº~%pð# tQ	xüñÇ¿¼uÛ¶‡r¹\\¼\n\ÜG]w,œ9Š>y–´m‘ª‚\Ïa$’U¿WJ042Á\Óý)¤gó›\Øp\éú`&\Î#;I<b±H6›e\á\ÂEtwwóúk¯‘\Ï\ç¯”ú08WðDÀC=´q\Ó\æÍ¿\È\årñ\êM,_£üsüUœ\Ê\Ùc˜\åQR¶•\Îa¥[ˆ\Ûi§HP*—Šüü˜\Ë8IR©Ÿùô-~@J¤Q[1\nw”ŒŽŒ’É¤\Éf³\è1ƒ\î\î+\Ë\ë\Ö]²ó•W^™w\Íð‡Á\Õk\×~7‘°-\Ï††¦ù6¯\ËbZ¸ü¥•Ê’Z¼\ÜñT#‘B\ÓÊ«€¦\áº.ûŽLrV\æPHn¾ù&\â¦Y3ýˆö]\Ï\ÃóCC\Ã,\î\è`llœ\Ö\Ö´.X€\ÓÕ•H%\í\ï·Î—€óŽ÷\ÝwßªE\Þ)‘R …D~*Eý¢\Æ\èT‰\Ô\âÕ¤;\×`e¡›–¯}M\'?•g\ïAŽVr)Ø¹c]]]¶k…\ê\ÖO0•\ÏÇ‰\Çã¸®\Ë\Ä\Ä¦\'aYØ©\Ôg÷\ìùÁ\Í•€eË–ýµm\Ûz°JS\\/\ë6:ü\â\×/R*–\Ð\ãš¦S*ùÃŸNñý7F8\îø…«·_\Å\æÍ›j[dªÀƒ ¸\ß\ß?À\êU+˜˜œ@*E¾P@J‰m\ÛhšN6—ý~t	Û‡–óº@6\Ûòq)k›š’¶]­ø\Ôö*4\å»\Ã\â\ÎNž9ü6‡Ÿü=\í¶ß£\áŠNQ·Q˜†\Æ\Ç>v#—¬»˜}µ&„oa\Ò%††‡ioÿŽ\ã\ï*SÒ·¼R©Œ¦k†AÂ¶¯Ù³g\Ï5»w\ï~5\èrd9º	\Ä\ã\Æ6¿C\n\Çuý-m‘M~óŸ«i\ÐÝ½!¿\Ùÿ\"§Š^ð€.%k×®\á\Úk¯!”¿¢–#DhQÁ.\Ïc`pw\Ý@ooR*¤ò[©\\Â²,â†\çyd2\Ù\ÝÀ«Óº~ÁD44›{\ï½w\éö«¯\éI§Ó¸®K¡X¤mÑ¢i\à\ë	0M]\Ó(‹œ<uŠ|¾@&“fÉ’%\Øv‚ÐšjMUµ^R000€\ç	6^¶žÞ¾\é…²™…b‘|>O¹\\šø\ÓÛ‡\Ýyç¢”ó’\Ð\Ð,\ËZcš\æm\Í$À\ß¥i\Z®\ë‹Åˆ›&\ëÖ­C)¤¿\ÕE\Ô]×´/}w²\Zd‡††¹ü²\rŒŽU]\"ü¾\ã8\0\è+š¦•kmm½Š™VUrC\Z\Íf—ûJ\r¸]Ÿ\0ªkú*\Ø/ ƒQ\Ða›¾$J\Â\Ô\ÔŽ\ã\Ò\Ò\Ò˜\Í5\ê6O\Ï\ÖuD2y\rð&\à1ûD©!	ç³€\ÅBø€B\Íá¡”¿%\"$\05¢»¼\ê+U§\Ñ:€B2:6F.—¥P,\Îe\Âÿ·×†)qÃ¼°ð;7 \â‚HhH€„6!…Ÿ\åI\àOP4M\"¥Ž¦ûkšV# *Q­\×H­\"Œ‘\áTø\Ð\Ñ\ÑN>Ÿ÷sŽ	Õ¾\ç\á3xl%À‡$¸\\À´¹aðì¯ŸkñA£ªl{Õ€\ä!<!<¼j#‚ó\àzZ¡Ó›v¬®\ß\rŠ¥\"ž$¬\åR9\È\êÁ‡\ÄF%¦øŽ\áyœ\È\Zp¶¯/ó\Øc1<<\ìw@\Ã\ïx2\ÒDl=)b\Z)\Â¿3	‚B¾X]]r§H£\"ƒ\ë\Ðt]\ÏEÀ\'¦‡®ñ\áˆ\Å\â\ß\Zt}\äQ¦&§jY`\0 \Ö\ZIJ•˜­T.cš¦ŸvGj$º®\Û\Ó\0O\'¡¡54$\àñ\Ç÷\î·m\ë‹C%!^Dsžð\"M\Ô\Ý÷{5¼\é\ÖR\ïQB*N…¸¯¦\Ã@)¥1S\ë\Ñóx#¬\ç<ú\è£OH%nó\\w\\D„ ¼|m\ãE\ï‰\Zq\Ñ\ßU\ïEÀ»®‹#»`Í‡.\ày.\Ìnf€\Ñ\ÃŠ3þô\ë\'Ož<\ÕÙ¹ø—­­­\×\'¬D›?\ÌG#»Ÿ#(©JV›’AÄ—Á½h\æWM{Eu¬8¥r™DÂ®¾h\ÕH\ìDxžG¡P\à™§Ÿ\Z=tø\Ð>|•*ñ+E@#\ÂU„~÷»\ß\rœ={ö§Ë–-oM&“[t]Ó”\nA\ÃZp¯Ž÷\Ñq_Éºœ_Š\Ú_©Tð\\\ÛN\ï4–„@I\Å[ò\ÃÀ‰\ã\Ç{†GF^¤6Ö—€‘ 9O&xÁ5Ážžžò¾}O>³j\åŠWR©ôfÓ²\Ú}kõšV²Z÷‹’0\Û~`‰ò®\ë¿M–HX³\æ¡H)\è\à§?þ\Ï?û,¥b±T,~<19\Ù\0\Â\ß]6\n8„kNs\èÅ‹\'¿þõ¯ß±|\åª\ÎeskôXtctD‚ZaøšœRõYaT\Ê\å2RJ’\É\ä,£8w\î,\ï9\Ê\á·\Þbrb‚J¥Œ\'Ä›ƒƒ?=œ\Å>†ÿŽÁE\Ðù¼8©µµµ¥þ\ák_»u\Å\Ò\å_]\ÐÚºÓ´L=´\Âhµ8<ž/°U*h7¦¦¦app³}½ôœ~Ÿ|~\ÊœRH\Çqþ411ùT\ï\Ù\Þ7\Ð}À0P¾P\àUsA>\Ë˜·\ß~ûº­[·~¡uQ\Û\'³™\ì\æ¸i\Z\ç3\å\é\â¹ü\ß<÷Ü´\ÉSd•<W,\ïy\èð\×.X\ã³u¾™¢‰mÛ¶u\íÜ¹óúŽÅ‹·g³¹\Ë\Ò\éôª„m/Š\Å=|•nºH)yñ…ø\íK/aÄ’\'Ä \ç¹ï—ŠÅ£ã““O\âû÷þª\nÐ¨pÁr1\ß\×ñ\'[6`wtt,Ø²eK\×Â…g³\Ù¥T‹iš))¥,\nå©©©roo\ïÔ¹\Þ\Þ\á\ÓgÎ„m\È\ãGò\n§»s–ÿÿJò=&\Ó\0\0\0\0IEND®B`‚','2024-09-30',1,'2024-10-01',NULL,1),(7,1,1,'art','1c1fe3772c78ae97b6c08f4cef13727dba2804760d968997bf4b9f0872b05837','awrt','awrt','awrt',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\00\0\0\00\0\0\0Wù‡\0\0\0sBIT|dˆ\0\0\0	pHYs\0\0\Ä\0\0\Ä•+\0\0	IDATh\í™il]\Å†Ÿo\Îr¯÷8^b\ãl\×\Îj;\é\Ùc\âˆ*j‹„Z\"JE‹„ \Ð?H­Ú¨•Z…ª\n¨*šBT¢)K\Ø\Z²(¤\"„¤	\à,\ØNÇ‰w\ß\íœ3\ÓŽ/÷:öM€?y¥ó\ç|g\æ{\ß9ß¼gf\ÜÀU¦\ê‹\è\Üú\":	\Û	½¤,{ƒRÒªµnþ2r^W\ØN\èe\'6v(¬m7\Ü`\Ûöª¯š\Óø\á8l7\Ô\î„\Âfð²\ÝP\ÔrB[€‚¯š^:0K\Ù\îÃ¶jJ~¸ð\Û@\áµ&º^˜ªgµˆ\Ü!P‡¨\nŒI›Ã€A›m¾—øn¦I¯]€\ã\ÔZ¢XH¡L°O\ÚOÄ«O2Iog\Òh–\å®‘­\"’q(\ìp~üKP\"–<-\äŒ1¢»3mŸ\é\ÇÅ¶\Ý\ÐˆL\É4ñ DÄ²E½†\ãÜœIû	0Æ¨%Ë–=\Ü3\ÑzO©˜©ü\ã‘#G&O´\í„lß¾=ô\ìsy¾ñ³\Æ?€8M`´\Æƒ1\Ã\ïA°\æbW\Ï\îw\Þ\Ù]9‘þ\Æ-`ûö\í!7œý\Ì\æ\'7o\ì\ì\êRƒ\æhŒ¡vN‘òBB¶ºDnø…1\ä†m¾9¯œ\ßüx\rO?ºŒÖ¿\çy’ˆÇ«°zµ¡¡a\æxy{g\ç\æÿüÔ©S?:\Ñ\Ø(Êº²„2ý\álX¾€Æ–9y–g.\Ð\ÓE	”\ØÌ©(b~¤”©\Åy ý7ñ\Ò\Û#j`$\nòó±,\ßóªCnø…†††õuuu}\×EÀŽ÷ö|[ó‹\â\â\"e\Û6z\È\ÈNŸ2‰šHY¶\ÅÂ™SX8óÊ¼Ÿd´ƒ\Ë\ß2\Ï<z\'\"Â‹oHe%\"‚1†¤—\\\á8\îï€‡®\Æ\íª%ô×††°m\É\á\Ü\Ü<ª««1\ÆPUQÄ›\Ï>\Âœ\ê4#W	[®\ç\Î\ås0FS[[‹\Öe¥µ– \Ð4\ì\Þ}\ë5ˆX\î}\Ì‚€+W^ªi—\ÛÏ¦8\'œ±e\Ù÷\Ü^F¨ªšuEŸA8¶Ø¿>xð\à˜f1f	mÛ¶-ôCZ\ë\Ëkjjq‡\îþøÀ0€zb	\Z[.‹%()) ²l2ˆ€hNœ\í «\'Æ¤‚lª\Êq¬±\Ë\Ë	“Ÿ—CQQÑ¨ü^\à¯	ú‚[\Ý	˜4©h¹1\Ìz¯¬¬Œ\Ü\Ü\\b‰$ƒo4{Î©–v\n\nr\É\Érim<K\ã\é6V-Š\Ð\Ýg\ï\ÇMX¶EVÈ¡­\éÿ=~†¯Ï¹‰yÓ‹PJ(˜4‰p8<*¿Û²\í°lkC\"™Vf\Ù\ÙÙ”\ßT\ÎÙ¦S \r–+j\"¬ª‰¼AˆøV^˜\ï,›;\Ì÷Em4Á4“\'aY©7‡\Úpû¶={ò6,_Þ›*žv<x\Ðñ}\ÔÎ©½½‚œ0¾?ðA”a8y`ñ%³\Z2‚\0É¤O²¿“÷÷\îp¶‘0¦¬Àó\Ò.3\Ò\nho\ï­P–5\Ì^,\Ëâ£½oðø½Ka\ÐJ‡ÀÓš¶ž(q?¥HCGoŒ¸‹D\ã\ë¾5¥%\ç8v\ì£xh£\Ë	/œ°\0q‚R\è\ìa÷D(p“,[a\ÖôÔˆ½Ê¡\Ï\Îpó÷~\Å+{bFxSkG5?xš\Þ:4,\ÒMPYVÈ¼iEt¶·¦¤¢uI\Ç3\í°±‹Œ²°@C^\Øe\Ãm‹A	\è+\ã¹xöTv<÷fLAF¼Š¢<\Þy\æ~*\Ë&].=d@Àº¥s	´F)wcï—¤\ã™ö\r¥Gõf$qÑf\ãú[\Ô­„Ú™eX\"þ9ó§r,†\î2\çGJ‰\ÜTHgwŒœüÔ‹Qƒ„&,@‘a\Ã>&4™‹\Ñ8GO·1\Ævw|0°ªv¶p´¹“òŠ©)%ý\éºH+@i«Ý²¬\ä\Èû•ó9p´	\Ñz”ñd‚®¾Ú¶ø°ESZR<*.\"Ø–Õ––gº€\ï\Ê9µ\Z¬ŒD8\Ø\Zæ½>G+A§²¾q\Â4§\Ïwó]\Í,XZŸ\ÚFÁ òYº>\Ò\n\Øÿ\î»mÆ˜¦T±•k\ÖA\éBš\Ïu\ÐKŽJ¬Á¿4?Œ1hb£5ýq†\Ïp\×}Q^^žš RñX_\ìÈ„lÚ´Icþ“ªÎµ\Ö,]ºŒ\×÷}BRk<=œ]s{7­$ü€ÖŽ>>i¾€\Z‘)\éDÉ¼™\é(@\ä´Ö‰\ã\0`Ä¼¬”òRÅ²²²he“ðú¢	ú\Ñ\ÄÀ£\ÓJ\n¨(Î§ù|Ž¥˜;½cÀ´6Ä“>I_s\èd;U5cp”ðJ}}}\"#ñ¾¾C\ÊR¤Ši­©˜½ˆÇ›\ÑZ\Ó\ÝÃº´»Š&<Â®\Ã\ì¥”\æ\Ò(3\Ï\×D½±$ýñ$ûNÄ©ªJ¿VJE}\ÌÖ±8Ž) ¾¾>!š\ß+¥RÎ®¹s\çq\èbÇšÎ£,u\ÙV5ðöû\Ç\Øü·¼ð\æ!zb	!\ä\Úx~€ˆ°uÇ§Üºö\î±\Ò#¢þy\Ûò\å£\×Cp\ÕÿÓ§Okœ5kö’@ëª”ñ\ÞÛ³Ÿ9\Ó\n\Èr­\Éqª¦–PU1™Å•“™œ—EhÚ»¢\à\Í|ma5\î”\ê´\ß\ÇqºcAò\îÙ‘H\×Xü®º#Û´i“Öz\Äq\ì©mN¸ÿû«yñõ\è\ê\Ó\Ñ¥?á¡aJQ>a\×\Æ4\Ýýq\Û\â£\Æs\äpó\ÌbF/a`Y*‘_®««;}5~\ã:VY½z\É11òS\Çq\â)øRÂƒw­\ä\Å7 ,Ego”3m]´œ\ï\âdk\'\ç»úñ|M\Ó\Å\ÎuôQË¬t\ÜDY[Ïmù\Óx¸û\Óô\éÓŽÏš=·\ÌÆ˜a\íÊœJ³ù¹¼º\ë0\Ù!—\Þhœ\Þhœ®®º£I\ÎwG\Ù¤…û\Ö/FŒ$De\îcPJ\áº\î¿C¶z`\íÚµ£+•\àñ\nÄ®½û\ÔA°\Ùó¼°ˆ`€Ú¬fJ\ì^@8\Ù\Ö\Éù=$ý«$Ñƒm+\\KQ]5…°= ½\×\äq˜E—)ˆˆq\\\ç_A2q\ïxÎƒ2\0°{÷¾\Õ\Zóg\ß÷\æhcd¨€¡0@¢¯=eCX–\Õ\ë8\Îo½D\ìÉºº:\"\\2:^±b\ÉN\í\'–‡\\÷)\Çq:2Y•Š€eYI\Çuw(¬\ÕË–\Üò\ÄD\É\Ãu8]Þµk×œo\ä7ÿ$\Ëôo\nñƒË±To@Y\nƒÄ¢v\ákGYô¬ŸH\ìÌ„ø ®\Û?2Ó´9‹öœ¥„øº†@\ÏÄ¶\n½\ÞvKŒ\î2Æœ\Û9’ôü½\É {ga\Ý\Ï\Æô÷ñ\âzþ\äó\éS!úu}m‚•ˆ³dKüÒœ¿¸\ëˆÿ\Ìi\ê\Ãº\0\0\0\0IEND®B`‚','2024-10-02',1,NULL,NULL,0),(8,1,1,'went','51432bbb9b31dc729a9c2d664114f75ec9c3342cdff3a0c3f41d9f7e77772786','er','tr','wt',NULL,'2024-10-02',1,'2024-10-02',1,0),(9,1,1,'carmen','db92ed8a0c0a0bbd7a6a280582ac049ef8e04bcb434adbc480f9d33b9abf9b67','wtrw','wryw','rywry',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\00\0\0\00\0\0\0Wù‡\0\0\0sBIT|dˆ\0\0\0	pHYs\0\0\Ä\0\0\Ä•+\0\0	IDATh\í™il]\Å†Ÿo\Îr¯÷8^b\ãl\×\Îj;\é\Ùc\âˆ*j‹„Z\"JE‹„ \Ð?H­Ú¨•Z…ª\n¨*šBT¢)K\Ø\Z²(¤\"„¤	\à,\ØNÇ‰w\ß\íœ3\ÓŽ/÷:öM€?y¥ó\ç|g\æ{\ß9ß¼gf\ÜÀU¦\ê‹\è\Üú\":	\Û	½¤,{ƒRÒªµnþ2r^W\ØN\èe\'6v(¬m7\Ü`\Ûöª¯š\Óø\á8l7\Ô\î„\Âfð²\ÝP\ÔrB[€‚¯š^:0K\Ù\îÃ¶jJ~¸ð\Û@\áµ&º^˜ªgµˆ\Ü!P‡¨\nŒI›Ã€A›m¾—øn¦I¯]€\ã\ÔZ¢XH¡L°O\ÚOÄ«O2Iog\Òh–\å®‘­\"’q(\ìp~üKP\"–<-\äŒ1¢»3mŸ\é\ÇÅ¶\Ý\ÐˆL\É4ñ DÄ²E½†\ãÜœIû	0Æ¨%Ë–=\Ü3\ÑzO©˜©ü\ã‘#G&O´\í„lß¾=ô\ìsy¾ñ³\Æ?€8M`´\Æƒ1\Ã\ïA°\æbW\Ï\îw\Þ\Ù]9‘þ\Æ-`ûö\í!7œý\Ì\æ\'7o\ì\ì\êRƒ\æhŒ¡vN‘òBB¶ºDnø…1\ä†m¾9¯œ\ßüx\rO?ºŒÖ¿\çy’ˆÇ«°zµ¡¡a\æxy{g\ç\æÿüÔ©S?:\Ñ\Ø(Êº²„2ý\álX¾€Æ–9y–g.\Ð\ÓE	”\ØÌ©(b~¤”©\Åy ý7ñ\Ò\Û#j`$\nòó±,\ßóªCnø…†††õuuu}\×EÀŽ÷ö|[ó‹\â\â\"e\Û6z\È\ÈNŸ2‰šHY¶\ÅÂ™SX8óÊ¼Ÿd´ƒ\Ë\ß2\Ï<z\'\"Â‹oHe%\"‚1†¤—\\\á8\îï€‡®\Æ\íª%ô×††°m\É\á\Ü\Ü<ª««1\ÆPUQÄ›\Ï>\Âœ\ê4#W	[®\ç\Î\ås0FS[[‹\Öe¥µ– \Ð4\ì\Þ}\ë5ˆX\î}\Ì‚€+W^ªi—\ÛÏ¦8\'œ±e\Ù÷\Ü^F¨ªšuEŸA8¶Ø¿>xð\à˜f1f	mÛ¶-ôCZ\ë\Ëkjjq‡\îþøÀ0€zb	\Z[.‹%()) ²l2ˆ€hNœ\í «\'Æ¤‚lª\Êq¬±\Ë\Ë	“Ÿ—CQQÑ¨ü^\à¯	ú‚[\Ý	˜4©h¹1\Ìz¯¬¬Œ\Ü\Ü\\b‰$ƒo4{Î©–v\n\nr\É\Érim<K\ã\é6V-Š\Ð\Ýg\ï\ÇMX¶EVÈ¡­\éÿ=~†¯Ï¹‰yÓ‹PJ(˜4‰p8<*¿Û²\í°lkC\"™Vf\Ù\ÙÙ”\ßT\ÎÙ¦S \r–+j\"¬ª‰¼AˆøV^˜\ï,›;\Ì÷Em4Á4“\'aY©7‡\Úpû¶={ò6,_Þ›*žv<x\Ðñ}\ÔÎ©½½‚œ0¾?ðA”a8y`ñ%³\Z2‚\0É¤O²¿“÷÷\îp¶‘0¦¬Àó\Ò.3\Ò\nho\ï­P–5\Ì^,\Ëâ£½oðø½Ka\ÐJ‡ÀÓš¶ž(q?¥HCGoŒ¸‹D\ã\ë¾5¥%\ç8v\ì£xh£\Ë	/œ°\0q‚R\è\ìa÷D(p“,[a\ÖôÔˆ½Ê¡\Ï\Îpó÷~\Å+{bFxSkG5?xš\Þ:4,\ÒMPYVÈ¼iEt¶·¦¤¢uI\Ç3\í°±‹Œ²°@C^\Øe\Ãm‹A	\è+\ã¹xöTv<÷fLAF¼Š¢<\Þy\æ~*\Ë&].=d@Àº¥s	´F)wcï—¤\ã™ö\r¥Gõf$qÑf\ãú[\Ô­„Ú™eX\"þ9ó§r,†\î2\çGJ‰\ÜTHgwŒœüÔ‹Qƒ„&,@‘a\Ã>&4™‹\Ñ8GO·1\Ævw|0°ªv¶p´¹“òŠ©)%ý\éºH+@i«Ý²¬\ä\Èû•ó9p´	\Ñz”ñd‚®¾Ú¶ø°ESZR<*.\"Ø–Õ––gº€\ï\Ê9µ\Z¬ŒD8\Ø\Zæ½>G+A§²¾q\Â4§\Ïwó]\Í,XZŸ\ÚFÁ òYº>\Ò\n\Øÿ\î»mÆ˜¦T±•k\ÖA\éBš\Ïu\ÐKŽJ¬Á¿4?Œ1hb£5ýq†\Ïp\×}Q^^žš RñX_\ìÈ„lÚ´Icþ“ªÎµ\Ö,]ºŒ\×÷}BRk<=œ]s{7­$ü€ÖŽ>>i¾€\Z‘)\éDÉ¼™\é(@\ä´Ö‰\ã\0`Ä¼¬”òRÅ²²²he“ðú¢	ú\Ñ\ÄÀ£\ÓJ\n¨(Î§ù|Ž¥˜;½cÀ´6Ä“>I_s\èd;U5cp”ðJ}}}\"#ñ¾¾C\ÊR¤Ši­©˜½ˆÇ›\ÑZ\Ó\ÝÃº´»Š&<Â®\Ã\ì¥”\æ\Ò(3\Ï\×D½±$ýñ$ûNÄ©ªJ¿VJE}\ÌÖ±8Ž) ¾¾>!š\ß+¥RÎ®¹s\çq\èbÇšÎ£,u\ÙV5ðöû\Ç\Øü·¼ð\æ!zb	!\ä\Úx~€ˆ°uÇ§Üºö\î±\Ò#¢þy\Ûò\å£\×Cp\ÕÿÓ§Okœ5kö’@ëª”ñ\ÞÛ³Ÿ9\Ó\n\Èr­\Éqª¦–PU1™Å•“™œ—EhÚ»¢\à\Í|ma5\î”\ê´\ß\ÇqºcAò\îÙ‘H\×Xü®º#Û´i“Öz\Äq\ì©mN¸ÿû«yñõ\è\ê\Ó\Ñ¥?á¡aJQ>a\×\Æ4\Ýýq\Û\â£\Æs\äpó\ÌbF/a`Y*‘_®««;}5~\ã:VY½z\É11òS\Çq\â)øRÂƒw­\ä\Å7 ,Ego”3m]´œ\ï\âdk\'\ç»úñ|M\Ó\Å\ÎuôQË¬t\ÜDY[Ïmù\Óx¸û\Óô\éÓŽÏš=·\ÌÆ˜a\íÊœJ³ù¹¼º\ë0\Ù!—\Þhœ\Þhœ®®º£I\ÎwG\Ù¤…û\Ö/FŒ$De\îcPJ\áº\î¿C¶z`\íÚµ£+•\àñ\nÄ®½û\ÔA°\Ùó¼°ˆ`€Ú¬fJ\ì^@8\Ù\Ö\Éù=$ý«$Ñƒm+\\KQ]5…°= ½\×\äq˜E—)ˆˆq\\\ç_A2q\ïxÎƒ2\0°{÷¾\Õ\Zóg\ß÷\æhcd¨€¡0@¢¯=eCX–\Õ\ë8\Îo½D\ìÉºº:\"\\2:^±b\ÉN\í\'–‡\\÷)\Çq:2Y•Š€eYI\Çuw(¬\ÕË–\Üò\ÄD\É\Ãu8]Þµk×œo\ä7ÿ$\Ëôo\nñƒË±To@Y\nƒÄ¢v\ákGYô¬ŸH\ìÌ„ø ®\Û?2Ó´9‹öœ¥„øº†@\ÏÄ¶\n½\ÞvKŒ\î2Æœ\Û9’ôü½\É {ga\Ý\Ï\Æô÷ñ\âzþ\äó\éS!úu}m‚•ˆ³dKüÒœ¿¸\ëˆÿ\Ìi\ê\Ãº\0\0\0\0IEND®B`‚','2024-10-02',1,'2024-10-02',1,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-04 20:17:27
