SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `adresdefteri`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hibernate_sequences`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `hibernate_sequences` (`sequence_name`, `next_val`) VALUES
('Iletisim', 26),
('Kisi', 14);


CREATE TABLE IF NOT EXISTS `Iletisim` (
  `id` int(11) NOT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `kisi_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhal4ujta1hv9x93v3l2nur38e` (`kisi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `Kisi`
--

CREATE TABLE IF NOT EXISTS `Kisi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ad` varchar(255) DEFAULT NULL,
  `adres` varchar(255) DEFAULT NULL,
  `e_posta` varchar(255) DEFAULT NULL,
  `soyad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;


ALTER TABLE `Iletisim`
  ADD CONSTRAINT `FKhal4ujta1hv9x93v3l2nur38e` FOREIGN KEY (`kisi_id`) REFERENCES `Kisi` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
