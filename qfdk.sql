-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2014-05-17 21:03:17
-- 服务器版本： 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qfdk`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `idUser` int(255) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT '0',
  `mdp` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`idUser`, `login`, `mdp`) VALUES
(1, 'admin', 'admin'),
(2, 'qfdk', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `commentaire`
--

CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCommentaire` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) CHARACTER SET utf8 NOT NULL,
  `contenu` longtext CHARACTER SET utf8 NOT NULL,
  `dateCommentaire` datetime NOT NULL,
  `idNews` int(255) NOT NULL,
  PRIMARY KEY (`idCommentaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `commentaire`
--

INSERT INTO `commentaire` (`idCommentaire`, `nom`, `contenu`, `dateCommentaire`, `idNews`) VALUES
(1, 'x', 'x', '2014-03-19 01:06:59', 1),
(2, 'd', 'd', '2014-03-19 02:01:39', 1),
(3, 'd', 'd', '2014-03-19 02:01:47', 1),
(4, 'ok', 'ok', '2014-03-19 02:03:05', 1),
(5, '中文', '中路卡三季度\n', '2014-03-19 12:51:41', 1),
(6, 'd', 'd', '2014-03-19 12:56:04', 4),
(7, 'we', 'er', '2014-03-19 12:56:12', 4),
(8, 'x', 'x', '2014-03-19 13:02:29', 4);

-- --------------------------------------------------------

--
-- 表的结构 `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `idNews` int(255) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `tags` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `contenu` longtext CHARACTER SET utf8,
  `score` int(100) DEFAULT '0',
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`idNews`),
  FULLTEXT KEY `contenu` (`contenu`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `news`
--

INSERT INTO `news` (`idNews`, `titre`, `tags`, `contenu`, `score`, `date`) VALUES
(1, 'Adaptateur', 'Java', '<h3 style="margin-top: 0px; margin-bottom: 0px; font-size: large; color: black; text-indent: 10px; font-family: Arial, Helvetica, sans-serif; line-height: normal;">Diagramme de classes pour l''adaptateur de classes :</h3><img src="http://www.goprod.bouhours.net/images/patterns/fr/69560358650af9c3b8b004.svg" alt="Diagramme de classes pour l''adaptateur de classes" title="Diagramme de classes pour l''adaptateur de classes" style="color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal; min-width: 300px; min-height: 150px;"><span style="color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal;"></span><h3 style="margin-top: 0px; margin-bottom: 0px; font-size: large; color: black; text-indent: 10px; font-family: Arial, Helvetica, sans-serif; line-height: normal;">Description :</h3><table class="marge_gauche" style="margin-left: 20px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal;"><tbody><tr><td class="nowrap" style="white-space: nowrap; vertical-align: top;"><i>Type :</i></td><td style="vertical-align: top;"><span title="Structurel" class="icon_pattern" style="color: white; font-family: cursive; border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-right-radius: 10px; border-bottom-left-radius: 10px; background-color: green;">&nbsp;St&nbsp;</span>&nbsp;(Structurel)</td></tr></tbody></table><table class="marge_gauche" style="margin-left: 20px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal;"><tbody><tr><td class="nowrap" style="white-space: nowrap; vertical-align: top;"><i>Intention :</i></td><td id="stv_pattern_applicability_2" style="vertical-align: top;">Convertit l''interface d''une classe en une autre conformément à l''attente du client. L''Adaptateur permet à des classes de collaborer, alors qu’elles n''auraient pas pu le faire du fait d''interfaces incompatibles.</td></tr></tbody></table><br>', NULL, '2014-03-18 22:22:58'),
(2, 'Chaîne de responsabilité', 'Java', '<h3 style="margin-top: 0px; margin-bottom: 0px; font-size: large; color: black; text-indent: 10px; font-family: Arial, Helvetica, sans-serif; line-height: normal;">Diagramme de classes :</h3><img src="http://www.goprod.bouhours.net/images/patterns/fr/38062408750af9c6cb0e5b.svg" alt="Diagramme de classes" title="Diagramme de classes" style="color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal; min-width: 300px; min-height: 150px;"><span style="color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal;"></span><h3 style="margin-top: 0px; margin-bottom: 0px; font-size: large; color: black; text-indent: 10px; font-family: Arial, Helvetica, sans-serif; line-height: normal;">Description :</h3><table class="marge_gauche" style="margin-left: 20px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal;"><tbody><tr><td class="nowrap" style="white-space: nowrap; vertical-align: top;"><i>Type :</i></td><td style="vertical-align: top;"><span title="Comportemental" class="icon_pattern" style="color: white; font-family: cursive; border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-right-radius: 10px; border-bottom-left-radius: 10px; background-color: blue;">&nbsp;Co&nbsp;</span>&nbsp;(Comportemental)</td></tr></tbody></table><table class="marge_gauche" style="margin-left: 20px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: normal;"><tbody><tr><td class="nowrap" style="white-space: nowrap; vertical-align: top;"><i>Intention :</i></td><td id="stv_pattern_applicability_2" style="vertical-align: top;">Évite le couplage de l''émetteur d''une requête avec ses récepteurs, en donnant à plus d''un objet la possibilité d''entreprendre la requête.<br>Chaîne les objets récepteurs et fait passer la requête tout au long de la chaîne, jusqu''à ce qu''un objet la traite.</td></tr></tbody></table>', NULL, '2014-03-18 22:23:30'),
(3, 'Projet Blog', 'News', '<p style="color: rgb(0, 0, 64); font-family: Times; font-size: medium; line-height: normal;">Le but du projet est de proposer la gestion complète d''un blog (journal de "news" ajoutées par date) en JAVA, en&nbsp;<font color="#0000FF"><strong>MVC</strong></font>.<br>La page principale du blog est composée d''une première partie supérieure (ou d''un menu), permettant d''administrer son blog, et d''une seconde partie composée des news affichées de la sorte: date : news. Cette page principale doit être découpée en plusieurs pages appelées par des liens, si le blog est trop important.<br></p>', NULL, '2014-03-18 22:33:38'),
(4, 'HelloWorld！', 'News', '&nbsp;int main(void)<div>{</div><div><blockquote style="margin: 0 0 0 40px; border: none; padding: 0px;"><div>printf("Hello World !\\n");</div></blockquote></div><div><blockquote style="margin: 0 0 0 40px; border: none; padding: 0px;"><div>retrun 0;</div></blockquote></div><div>}</div>', NULL, '2014-03-19 00:10:56');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
