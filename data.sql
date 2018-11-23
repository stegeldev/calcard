
CREATE TABLE IF NOT EXISTS `propostas` (
`id` bigint(20) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `idade` int(11) NOT NULL,
  `sexo` char(1) NOT NULL,
  `estadoCivil` varchar(30) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `dependentes` int(11) NOT NULL,
  `renda` double NOT NULL,
  `resultadoAnalise` varchar(10) DEFAULT 'Em Análise',
  `limite` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;


ALTER TABLE `propostas`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `propostas`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
