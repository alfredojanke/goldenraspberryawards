package com.texoit.goldenraspberryawards.service;

import com.texoit.goldenraspberryawards.indicadosvencedores.model.Movie;
import com.texoit.goldenraspberryawards.indicadosvencedores.repository.MovieRepository;
import com.texoit.goldenraspberryawards.indicadosvencedores.service.MovieCsvReader;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class MovieCsvReaderTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieCsvReader movieCsvReader;

    @Captor
    ArgumentCaptor<Movie> movieCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readCsvFile(){

        Mockito.when(movieRepository.save(Mockito.any())).thenReturn(Mockito.any());

        movieCsvReader.readCsvFile();

        Mockito.verify(movieRepository,Mockito.times(206)).save(Mockito.any());

        Mockito.verify(movieRepository,Mockito.times(206)).save(movieCaptor.capture());

        List<Movie> movieArgumentCaptorValue = movieCaptor.getAllValues();


        verifyMovie(1980,"Can't Stop the Music","Associated Film Distribution","Allan Carr",true,movieArgumentCaptorValue.get(0));
        verifyMovie(1980,"Cruising","Lorimar Productions, United Artists","Jerry Weintraub",false,movieArgumentCaptorValue.get(1));
        verifyMovie(1980,"The Formula","MGM, United Artists","Steve Shagan",false,movieArgumentCaptorValue.get(2));
        verifyMovie(1980,"Friday the 13th","Paramount Pictures","Sean S. Cunningham",false,movieArgumentCaptorValue.get(3));
        verifyMovie(1980,"The Nude Bomb","Universal Studios","Jennings Lang",false,movieArgumentCaptorValue.get(4));
        verifyMovie(1980,"The Jazz Singer","Associated Film Distribution","Jerry Leider",false,movieArgumentCaptorValue.get(5));
        verifyMovie(1980,"Raise the Titanic","Associated Film Distribution","William Frye",false,movieArgumentCaptorValue.get(6));
        verifyMovie(1980,"Saturn 3","Associated Film Distribution","Stanley Donen",false,movieArgumentCaptorValue.get(7));
        verifyMovie(1980,"Windows","United Artists","Mike Lobell",false,movieArgumentCaptorValue.get(8));
        verifyMovie(1980,"Xanadu","Universal Studios","Lawrence Gordon",false,movieArgumentCaptorValue.get(9));
        verifyMovie(1981,"Mommie Dearest","Paramount Pictures","Frank Yablans",true,movieArgumentCaptorValue.get(10));
        verifyMovie(1981,"Endless Love","Universal Studios, PolyGram","Dyson Lovell",false,movieArgumentCaptorValue.get(11));
        verifyMovie(1981,"Heaven's Gate","United Artists","Joann Carelli",false,movieArgumentCaptorValue.get(12));
        verifyMovie(1981,"The Legend of the Lone Ranger","Universal Studios, Associated Film Distribution","Walter Coblenz",false,movieArgumentCaptorValue.get(13));
        verifyMovie(1981,"Tarzan, the Ape Man","MGM, United Artists","John Derek",false,movieArgumentCaptorValue.get(14));
        verifyMovie(1982,"Inchon","MGM","Mitsuharu Ishii",true,movieArgumentCaptorValue.get(15));
        verifyMovie(1982,"Annie","Columbia Pictures","Ray Stark",false,movieArgumentCaptorValue.get(16));
        verifyMovie(1982,"Butterfly","Analysis Film Releasing","Matt Cimber",false,movieArgumentCaptorValue.get(17));
        verifyMovie(1982,"Megaforce","20th Century Fox","Albert S. Ruddy",false,movieArgumentCaptorValue.get(18));
        verifyMovie(1982,"The Pirate Movie","20th Century Fox","David Joseph",false,movieArgumentCaptorValue.get(19));
        verifyMovie(1983,"The Lonely Lady","Universal Studios","Robert R. Weston",true,movieArgumentCaptorValue.get(20));
        verifyMovie(1983,"Hercules","MGM, United Artists, Cannon Films","Yoram Globus and Menahem Golan",false,movieArgumentCaptorValue.get(21));
        verifyMovie(1983,"Jaws 3-D","Universal Studios","Rupert Hitzig",false,movieArgumentCaptorValue.get(22));
        verifyMovie(1983,"Stroker Ace","Warner Bros., Universal Studios","Hank Moonjean",false,movieArgumentCaptorValue.get(23));
        verifyMovie(1983,"Two of a Kind","20th Century Fox","Roger M. Rothstein and Joe Wizan",false,movieArgumentCaptorValue.get(24));
        verifyMovie(1984,"Bolero","Cannon Films","Bo Derek",true,movieArgumentCaptorValue.get(25));
        verifyMovie(1984,"Cannonball Run II","Warner Bros.","Albert S. Ruddy",false,movieArgumentCaptorValue.get(26));
        verifyMovie(1984,"Rhinestone","20th Century Fox","Marvin Worth and Howard Smith",false,movieArgumentCaptorValue.get(27));
        verifyMovie(1984,"Sheena","Columbia Pictures","Paul Aratow",false,movieArgumentCaptorValue.get(28));
        verifyMovie(1984,"Where the Boys Are '84","TriStar Pictures","Allan Carr",false,movieArgumentCaptorValue.get(29));
        verifyMovie(1985,"Rambo: First Blood Part II","Columbia Pictures","Buzz Feitshans",true,movieArgumentCaptorValue.get(30));
        verifyMovie(1985,"Fever Pitch","MGM, United Artists","Freddie Fields",false,movieArgumentCaptorValue.get(31));
        verifyMovie(1985,"Revolution","Warner Bros.","Irwin Winkler",false,movieArgumentCaptorValue.get(32));
        verifyMovie(1985,"Rocky IV","MGM, United Artists","Irwin Winkler and Robert Chartoff",false,movieArgumentCaptorValue.get(33));
        verifyMovie(1985,"Year of the Dragon","MGM, United Artists","Dino De Laurentiis",false,movieArgumentCaptorValue.get(34));
        verifyMovie(1986,"Howard the Duck","Universal Studios","Gloria Katz",true,movieArgumentCaptorValue.get(35));
        verifyMovie(1986,"Under the Cherry Moon","Warner Bros.","Bob Cavallo, Joe Ruffalo and Steve Fargnoli",true,movieArgumentCaptorValue.get(36));
        verifyMovie(1986,"Blue City","Paramount Pictures","William L. Hayward and Walter Hill",false,movieArgumentCaptorValue.get(37));
        verifyMovie(1986,"Cobra","Warner Bros., Cannon Films","Yoram Globus and Menahem Golan",false,movieArgumentCaptorValue.get(38));
        verifyMovie(1986,"Shanghai Surprise","MGM","John Kohn",false,movieArgumentCaptorValue.get(39));
        verifyMovie(1987,"Leonard Part 6","Columbia Pictures","Bill Cosby",true,movieArgumentCaptorValue.get(40));
        verifyMovie(1987,"Ishtar","Columbia Pictures","Warren Beatty",false,movieArgumentCaptorValue.get(41));
        verifyMovie(1987,"Jaws: The Revenge","Universal Studios","Joseph Sargent",false,movieArgumentCaptorValue.get(42));
        verifyMovie(1987,"Tough Guys Don't Dance","Cannon Films","Yoram Globus and Menahem Golan",false,movieArgumentCaptorValue.get(43));
        verifyMovie(1987,"Who's That Girl","Warner Bros.","Rosilyn Heller and Bernard Williams",false,movieArgumentCaptorValue.get(44));
        verifyMovie(1988,"Cocktail","Touchstone Pictures","Ted Field and Robert W. Cort",true,movieArgumentCaptorValue.get(45));
        verifyMovie(1988,"Caddyshack II","Warner Bros.","Neil Canton, Jon Peters and Peter Guber",false,movieArgumentCaptorValue.get(46));
        verifyMovie(1988,"Hot to Trot","Warner Bros.","Steve Tisch",false,movieArgumentCaptorValue.get(47));
        verifyMovie(1988,"Mac and Me","Orion Pictures","R. J. Louis",false,movieArgumentCaptorValue.get(48));
        verifyMovie(1988,"Rambo III","TriStar Pictures, Carolco Pictures","Buzz Feitshans",false,movieArgumentCaptorValue.get(49));
        verifyMovie(1989,"Star Trek V: The Final Frontier","Paramount Pictures","Harve Bennett",true,movieArgumentCaptorValue.get(50));
        verifyMovie(1989,"The Karate Kid Part III","Columbia Pictures","Jerry Weintraub",false,movieArgumentCaptorValue.get(51));
        verifyMovie(1989,"Lock Up","TriStar Pictures, Carolco Pictures","Charles Gordon and Lawrence Gordon",false,movieArgumentCaptorValue.get(52));
        verifyMovie(1989,"Road House","United Artists","Joel Silver",false,movieArgumentCaptorValue.get(53));
        verifyMovie(1989,"Speed Zone","Orion Pictures","Murray Shostack",false,movieArgumentCaptorValue.get(54));
        verifyMovie(1990,"The Adventures of Ford Fairlane","20th Century Fox","Steven Perry and Joel Silver",true,movieArgumentCaptorValue.get(55));
        verifyMovie(1990,"Ghosts Can't Do It","Triumph Releasing","Bo Derek",true,movieArgumentCaptorValue.get(56));
        verifyMovie(1990,"The Bonfire of the Vanities","Warner Bros.","Brian De Palma",false,movieArgumentCaptorValue.get(57));
        verifyMovie(1990,"Graffiti Bridge","Warner Bros.","Randy Phillips and Craig Rice",false,movieArgumentCaptorValue.get(58));
        verifyMovie(1990,"Rocky V","United Artists","Robert Chartoff and Irwin Winkler",false,movieArgumentCaptorValue.get(59));
        verifyMovie(1991,"Hudson Hawk","TriStar Pictures","Joel Silver",true,movieArgumentCaptorValue.get(60));
        verifyMovie(1991,"Cool as Ice","Universal Studios","Carolyn Pfeiffer and Lionel Wingram",false,movieArgumentCaptorValue.get(61));
        verifyMovie(1991,"Dice Rules","Seven Arts Productions","Loucas George",false,movieArgumentCaptorValue.get(62));
        verifyMovie(1991,"Nothing but Trouble","Warner Bros.","Lester Berman and Robert K. Weiss",false,movieArgumentCaptorValue.get(63));
        verifyMovie(1991,"Return to the Blue Lagoon","Columbia Pictures","William A. Graham",false,movieArgumentCaptorValue.get(64));
        verifyMovie(1992,"Shining Through","20th Century Fox","Carol Baum and Howard Rosenman",true,movieArgumentCaptorValue.get(65));
        verifyMovie(1992,"The Bodyguard","Warner Bros.","Kevin Costner, Lawrence Kasdan and Jim Wilson",false,movieArgumentCaptorValue.get(66));
        verifyMovie(1992,"Christopher Columbus: The Discovery","Warner Bros.","Alexander Salkind and Ilya Salkind",false,movieArgumentCaptorValue.get(67));
        verifyMovie(1992,"Final Analysis","20th Century Fox","Paul Junger Witt, Charles Roven and Tony Thomas",false,movieArgumentCaptorValue.get(68));
        verifyMovie(1992,"Newsies","Walt Disney Pictures","Michael Finnell",false,movieArgumentCaptorValue.get(69));
        verifyMovie(1993,"Indecent Proposal","Paramount Pictures","Sherry Lansing",true,movieArgumentCaptorValue.get(70));
        verifyMovie(1993,"Body of Evidence","MGM, United Artists","Dino De Laurentiis",false,movieArgumentCaptorValue.get(71));
        verifyMovie(1993,"Cliffhanger","TriStar Pictures, Carolco Pictures","Renny Harlin and Alan Marshall",false,movieArgumentCaptorValue.get(72));
        verifyMovie(1993,"Last Action Hero","Columbia Pictures","John McTiernan and Stephen J. Roth",false,movieArgumentCaptorValue.get(73));
        verifyMovie(1993,"Sliver","Paramount Pictures","Robert Evans",false,movieArgumentCaptorValue.get(74));
        verifyMovie(1994,"Color of Night","Hollywood Pictures","Buzz Feitshans and David Matalon",true,movieArgumentCaptorValue.get(75));
        verifyMovie(1994,"North","Columbia Pictures, Castle Rock Entertainment","Rob Reiner and Alan Zweibel",false,movieArgumentCaptorValue.get(76));
        verifyMovie(1994,"On Deadly Ground","Warner Bros.","A. Kitman Ho, Julius R. Nasso and Steven Seagal",false,movieArgumentCaptorValue.get(77));
        verifyMovie(1994,"The Specialist","Warner Bros.","Jerry Weintraub",false,movieArgumentCaptorValue.get(78));
        verifyMovie(1994,"Wyatt Earp","Warner Bros.","Kevin Costner, Lawrence Kasdan and Jim Wilson",false,movieArgumentCaptorValue.get(79));
        verifyMovie(1995,"Showgirls","MGM, United Artists","Charles Evans and Alan Marshall",true,movieArgumentCaptorValue.get(80));
        verifyMovie(1995,"Congo","Paramount Pictures","Kathleen Kennedy and Sam Mercer",false,movieArgumentCaptorValue.get(81));
        verifyMovie(1995,"It's Pat","Touchstone Pictures","Charles B. Wessler",false,movieArgumentCaptorValue.get(82));
        verifyMovie(1995,"The Scarlet Letter","Hollywood Pictures","Roland Joffé and Andrew G. Vajna",false,movieArgumentCaptorValue.get(83));
        verifyMovie(1995,"Waterworld","Universal Studios","Kevin Costner, John Davis, Charles Gordon and Lawrence Gordon",false,movieArgumentCaptorValue.get(84));
        verifyMovie(1996,"Striptease","Columbia Pictures, Castle Rock Entertainment","Andrew Bergman and Mike Lobell",true,movieArgumentCaptorValue.get(85));
        verifyMovie(1996,"Barb Wire","PolyGram Filmed Entertainment, Gramercy Pictures","Todd Moyer, Mike Richardson and Brad Wyman",false,movieArgumentCaptorValue.get(86));
        verifyMovie(1996,"Ed","Universal Studios","Rosalie Swedlin",false,movieArgumentCaptorValue.get(87));
        verifyMovie(1996,"The Island of Dr. Moreau","New Line Cinema","Edward R. Pressman",false,movieArgumentCaptorValue.get(88));
        verifyMovie(1996,"The Stupids","New Line Cinema, Savoy Pictures","Leslie Belzberg",false,movieArgumentCaptorValue.get(89));
        verifyMovie(1997,"The Postman","Warner Bros.","Kevin Costner, Steve Tisch and Jim Wilson",true,movieArgumentCaptorValue.get(90));
        verifyMovie(1997,"Anaconda","Columbia Pictures","Verna Harrah, Carole Little and Leonard Rabinowitz",false,movieArgumentCaptorValue.get(91));
        verifyMovie(1997,"Batman & Robin","Warner Bros.","Peter MacGregor-Scott",false,movieArgumentCaptorValue.get(92));
        verifyMovie(1997,"Fire Down Below","Warner Bros.","Julius R. Nasso and Steven Seagal",false,movieArgumentCaptorValue.get(93));
        verifyMovie(1997,"Speed 2: Cruise Control","20th Century Fox","Jan de Bont, Steve Perry and Michael Peyser",false,movieArgumentCaptorValue.get(94));
        verifyMovie(1998,"An Alan Smithee Film: Burn Hollywood Burn","Hollywood Pictures","Ben Myron and Joe Eszterhas",true,movieArgumentCaptorValue.get(95));
        verifyMovie(1998,"Armageddon","Touchstone Pictures","Michael Bay and Jerry Bruckheimer",false,movieArgumentCaptorValue.get(96));
        verifyMovie(1998,"The Avengers","Warner Bros.","Jerry Weintraub",false,movieArgumentCaptorValue.get(97));
        verifyMovie(1998,"Godzilla","TriStar Pictures","Roland Emmerich and Dean Devlin",false,movieArgumentCaptorValue.get(98));
        verifyMovie(1998,"Spice World","Columbia Pictures","Uri Fruchtan, Mark L. Rosen and Barnaby Thompson",false,movieArgumentCaptorValue.get(99));
        verifyMovie(1999,"Wild Wild West","Warner Bros.","Jon Peters and Barry Sonnenfeld",true,movieArgumentCaptorValue.get(100));
        verifyMovie(1999,"Big Daddy","Columbia Pictures","Sidney Ganis and Jack Giarraputo",false,movieArgumentCaptorValue.get(101));
        verifyMovie(1999,"The Blair Witch Project","Artisan Entertainment","Robin Cowie and Gregg Hale",false,movieArgumentCaptorValue.get(102));
        verifyMovie(1999,"The Haunting","DreamWorks","Susan Arthur, Donna Roth and Colin Wilson",false,movieArgumentCaptorValue.get(103));
        verifyMovie(1999,"Star Wars: Episode I – The Phantom Menace","20th Century Fox","Rick McCallum and George Lucas",false,movieArgumentCaptorValue.get(104));
        verifyMovie(2000,"Battlefield Earth","Warner Bros., Franchise Pictures","Jonathan D. Krane, Elie Samaha and John Travolta",true,movieArgumentCaptorValue.get(105));
        verifyMovie(2000,"Book of Shadows: Blair Witch 2","Artisan Entertainment","Bill Carraro",false,movieArgumentCaptorValue.get(106));
        verifyMovie(2000,"The Flintstones in Viva Rock Vegas","Universal Studios","Bruce Cohen",false,movieArgumentCaptorValue.get(107));
        verifyMovie(2000,"Little Nicky","New Line Cinema","Jack Giarraputo and Robert Simonds",false,movieArgumentCaptorValue.get(108));
        verifyMovie(2000,"The Next Best Thing","Paramount Pictures","Leslie Dixon, Linne Radmin and Tom Rosenberg",false,movieArgumentCaptorValue.get(109));
        verifyMovie(2001,"Freddy Got Fingered","20th Century Fox","Larry Brezner, Howard Lapides and Lauren Lloyd",true,movieArgumentCaptorValue.get(110));
        verifyMovie(2001,"Driven","Warner Bros., Franchise Pictures","Renny Harlin, Elie Samaha and Sylvester Stallone",false,movieArgumentCaptorValue.get(111));
        verifyMovie(2001,"Glitter","20th Century Fox, Columbia Pictures","Laurence Mark and E. Bennett Walsh",false,movieArgumentCaptorValue.get(112));
        verifyMovie(2001,"Pearl Harbor","Touchstone Pictures","Michael Bay and Jerry Bruckheimer",false,movieArgumentCaptorValue.get(113));
        verifyMovie(2001,"3000 Miles to Graceland","Warner Bros., Franchise Pictures","Demian Lichtenstein, Eric Manes, Elie Samaha, Richard Spero and Andrew Stevens",false,movieArgumentCaptorValue.get(114));
        verifyMovie(2002,"Swept Away","Screen Gems","Matthew Vaughn",true,movieArgumentCaptorValue.get(115));
        verifyMovie(2002,"The Adventures of Pluto Nash","Warner Bros.","Martin Bregman, Michael Scott Bregman and Louis A. Stroller",false,movieArgumentCaptorValue.get(116));
        verifyMovie(2002,"Crossroads","Paramount Pictures","Ann Carli",false,movieArgumentCaptorValue.get(117));
        verifyMovie(2002,"Pinocchio","Miramax Films","Gianluigi Braschi, Nicoletta Braschi and Elda Ferri",false,movieArgumentCaptorValue.get(118));
        verifyMovie(2002,"Star Wars: Episode II – Attack of the Clones","20th Century Fox","Rick McCallum and George Lucas",false,movieArgumentCaptorValue.get(119));
        verifyMovie(2003,"Gigli","Columbia Pictures, Revolution Studios","Martin Brest and Casey Silver",true,movieArgumentCaptorValue.get(120));
        verifyMovie(2003,"The Cat in the Hat","Universal Studios, DreamWorks","Brian Grazer",false,movieArgumentCaptorValue.get(121));
        verifyMovie(2003,"Charlie's Angels: Full Throttle","Columbia Pictures","Drew Barrymore, Leonard Goldberg and Nancy Juvonen",false,movieArgumentCaptorValue.get(122));
        verifyMovie(2003,"From Justin to Kelly","20th Century Fox","John Steven Agoglia",false,movieArgumentCaptorValue.get(123));
        verifyMovie(2003,"The Real Cancun","New Line Cinema","Mary-Ellis Bunim, Jonathan Murray, Jamie Schutz and Rick de Oliveira",false,movieArgumentCaptorValue.get(124));
        verifyMovie(2004,"Catwoman","Warner Bros.","Denise Di Novi and Edward McDonnell",true,movieArgumentCaptorValue.get(125));
        verifyMovie(2004,"Alexander","Warner Bros.","Moritz Borman, Jon Kilik, Thomas Schuhly and Iain Smith",false,movieArgumentCaptorValue.get(126));
        verifyMovie(2004,"Superbabies: Baby Geniuses 2","Triumph Films","Steven Paul",false,movieArgumentCaptorValue.get(127));
        verifyMovie(2004,"Surviving Christmas","DreamWorks","Betty Thomas and Jenno Topping",false,movieArgumentCaptorValue.get(128));
        verifyMovie(2004,"White Chicks","Columbia Pictures, Revolution Studios","Rick Alvarez, Lee R. Mayes, Keenen Ivory Wayans, Marlon Wayans and Shawn Wayans",false,movieArgumentCaptorValue.get(129));
        verifyMovie(2005,"Dirty Love","First Look Pictures","John Mallory Asher, BJ Davis, Rod Hamilton, Kimberley Kates, Michael Manasseri, Jenny McCarthy and Trent Walford",true,movieArgumentCaptorValue.get(130));
        verifyMovie(2005,"Deuce Bigalow: European Gigolo","Columbia Pictures","Adam Sandler and Rob Schneider",false,movieArgumentCaptorValue.get(131));
        verifyMovie(2005,"The Dukes of Hazzard","Warner Bros., Village Roadshow","Bill Gerber",false,movieArgumentCaptorValue.get(132));
        verifyMovie(2005,"House of Wax","Warner Bros., Village Roadshow","Susan Levin, Joel Silver and Robert Zemeckis",false,movieArgumentCaptorValue.get(133));
        verifyMovie(2005,"Son of the Mask","New Line Cinema","Erica Huggins and Scott Kroopf",false,movieArgumentCaptorValue.get(134));
        verifyMovie(2006,"Basic Instinct 2","MGM, C2 Pictures","Mario Kassar, Joel B. Michaels and Andrew G. Vajna",true,movieArgumentCaptorValue.get(135));
        verifyMovie(2006,"BloodRayne","Romar Entertainment","Uwe Boll, Dan Clarke and Wolfgang Herrold",false,movieArgumentCaptorValue.get(136));
        verifyMovie(2006,"Lady in the Water","Warner Bros.","Sam Mercer, Jose L. Rodriguez and M. Night Shyamalan",false,movieArgumentCaptorValue.get(137));
        verifyMovie(2006,"Little Man","Columbia Pictures, Revolution Studios","Rick Alvares, Lee Mays, Marlon Wayans and Shawn Wayans",false,movieArgumentCaptorValue.get(138));
        verifyMovie(2006,"The Wicker Man","Warner Bros.","Nicolas Cage, Randall Emmett, Norm Golightly, Avi Lerner and Joanne Sellar",false,movieArgumentCaptorValue.get(139));
        verifyMovie(2007,"I Know Who Killed Me","TriStar Pictures","David Grace and Frank Mancuso Jr.",false,movieArgumentCaptorValue.get(140));
        verifyMovie(2007,"Bratz","Lionsgate","Avi Arad, Isaac Larian and Steven Paul",false,movieArgumentCaptorValue.get(141));
        verifyMovie(2007,"Daddy Day Camp","TriStar Pictures, Revolution Studios","Matt Berenson, John Davis and Wyck Godfrey",false,movieArgumentCaptorValue.get(142));
        verifyMovie(2007,"I Now Pronounce You Chuck & Larry","Universal Studios","Adam Sandler and Tom Shadyac",false,movieArgumentCaptorValue.get(143));
        verifyMovie(2007,"Norbit","DreamWorks","John Davis, Eddie Murphy and Michael Tollin",false,movieArgumentCaptorValue.get(144));
        verifyMovie(2008,"The Love Guru","Paramount Pictures","Gary Barber, Michael DeLuca and Mike Myers",true,movieArgumentCaptorValue.get(145));
        verifyMovie(2008,"Disaster Movie and Meet the Spartans","Lionsgate, 20th Century Fox","Jason Friedberg, Peter Safran and Aaron Seltzer",false,movieArgumentCaptorValue.get(146));
        verifyMovie(2008,"The Happening","20th Century Fox","Barry Mendel, Sam Mercer and M. Night Shyamalan",false,movieArgumentCaptorValue.get(147));
        verifyMovie(2008,"The Hottie & the Nottie","Regent Releasing","Hadeel Reda",false,movieArgumentCaptorValue.get(148));
        verifyMovie(2008,"In the Name of the King","Boll KG, Brightlight Pictures","Uwe Boll, Dan Clarke, Wolfgang Herrold and Shawn Williamson",false,movieArgumentCaptorValue.get(149));
        verifyMovie(2009,"Transformers: Revenge of the Fallen","Paramount Pictures, DreamWorks, Hasbro","Lorenzo di Bonaventura, Ian Bryce, Tom DeSanto and Don Murphy",true,movieArgumentCaptorValue.get(150));
        verifyMovie(2009,"All About Steve","20th Century Fox","Sandra Bullock and Mary McLaglen",false,movieArgumentCaptorValue.get(151));
        verifyMovie(2009,"G.I. Joe: The Rise of Cobra","Paramount Pictures, Hasbro","Lorenzo di Bonaventura, Bob Ducsay and Brian Goldner",false,movieArgumentCaptorValue.get(152));
        verifyMovie(2009,"Land of the Lost","Universal Studios","Sid and Marty Krofft and Jimmy Miller",false,movieArgumentCaptorValue.get(153));
        verifyMovie(2009,"Old Dogs","Walt Disney Pictures","Peter Abrams, Robert Levy and Andrew Panay",false,movieArgumentCaptorValue.get(154));
        verifyMovie(2010,"The Last Airbender","Paramount Pictures, Nickelodeon Movies","Frank Marshall, Kathleen Kennedy, Sam Mercer and M. Night Shyamalan",true,movieArgumentCaptorValue.get(155));
        verifyMovie(2010,"The Bounty Hunter","Columbia Pictures","Neal H. Moritz",false,movieArgumentCaptorValue.get(156));
        verifyMovie(2010,"Sex and the City 2","New Line Cinema, HBO Films, Village Roadshow Pictures","Michael Patrick King, John Melfi, Sarah Jessica Parker and Darren Star",false,movieArgumentCaptorValue.get(157));
        verifyMovie(2010,"The Twilight Saga: Eclipse","Summit Entertainment","Wyck Godfrey and Karen Rosenfelt",false,movieArgumentCaptorValue.get(158));
        verifyMovie(2010,"Vampires Suck","20th Century Fox","Jason Friedberg, Peter Safran and Aaron Seltzer",false,movieArgumentCaptorValue.get(159));
        verifyMovie(2011,"Jack and Jill","Columbia Pictures","Todd Garner, Jack Giarraputo and Adam Sandler",true,movieArgumentCaptorValue.get(160));
        verifyMovie(2011,"Bucky Larson: Born to Be a Star","Columbia Pictures","Barry Bernardi, Allen Covert, David Dorfman and Jack Giarraputo",false,movieArgumentCaptorValue.get(161));
        verifyMovie(2011,"New Year's Eve","Warner Bros., New Line Cinema","Mike Karz, Garry Marshall and Wayne Allan Rice",false,movieArgumentCaptorValue.get(162));
        verifyMovie(2011,"Transformers: Dark of the Moon","Paramount Pictures","Lorenzo di Bonaventura, Ian Bryce, Tom DeSanto and Don Murphy",false,movieArgumentCaptorValue.get(163));
        verifyMovie(2011,"The Twilight Saga: Breaking Dawn – Part 1","Summit Entertainment","Wyck Godfrey, Stephenie Meyer and Karen Rosenfelt",false,movieArgumentCaptorValue.get(164));
        verifyMovie(2012,"The Twilight Saga: Breaking Dawn – Part 2","Summit Entertainment","Wyck Godfrey, Stephenie Meyer and Karen Rosenfelt",true,movieArgumentCaptorValue.get(165));
        verifyMovie(2012,"Battleship","Universal Studios","Sarah Aubrey, Peter Berg, Brian Goldner, Duncan Henderson, Bennett Schneir and Scott Stuber",false,movieArgumentCaptorValue.get(166));
        verifyMovie(2012,"The Oogieloves in the Big Balloon Adventure","Lionsgate Films, Romar Entertainment, Kenn Viselman Presents","Gayle Dickie, Kenn Viselman",false,movieArgumentCaptorValue.get(167));
        verifyMovie(2012,"That's My Boy","Columbia Pictures","Allen Covert, Jack Giarraputo, Heather Parry and Adam Sandler",false,movieArgumentCaptorValue.get(168));
        verifyMovie(2012,"A Thousand Words","Paramount Pictures, DreamWorks","Nicolas Cage, Alain Chabat, Stephanie Danan, Norman Golightly, Brian Robbinsand Sharla Sumpter Bridgett",false,movieArgumentCaptorValue.get(169));
        verifyMovie(2013,"Movie 43","Relativity Media","Peter Farrelly, Ryan Kavanaugh, John Penotti and Charles B. Wessler",true,movieArgumentCaptorValue.get(170));
        verifyMovie(2013,"After Earth","Columbia Pictures","James Lassiter, Caleeb Pinkett, Jada Pinkett Smith, M. Night Shyamalan, Will Smith and Jaden Smith",false,movieArgumentCaptorValue.get(171));
        verifyMovie(2013,"Grown Ups 2","Columbia Pictures","Jack Giarraputo and Adam Sandler",false,movieArgumentCaptorValue.get(172));
        verifyMovie(2013,"The Lone Ranger","Walt Disney Pictures","Jerry Bruckheimer and Gore Verbinski",false,movieArgumentCaptorValue.get(173));
        verifyMovie(2013,"A Madea Christmas","Lionsgate","Ozzie Areu, Matt Moore and Tyler Perry",false,movieArgumentCaptorValue.get(174));
        verifyMovie(2014,"Saving Christmas","Samuel Goldwyn Films","Darren Doane, Raphi Henley, Amanda Rosser and David Shannon",true,movieArgumentCaptorValue.get(175));
        verifyMovie(2014,"Left Behind","Freestyle Releasing, Entertainment One","Michael Walker and Paul LaLonde",false,movieArgumentCaptorValue.get(176));
        verifyMovie(2014,"The Legend of Hercules","Summit Entertainment","Boaz Davidson, Renny Harlin, Danny Lerner and Les Weldon",false,movieArgumentCaptorValue.get(177));
        verifyMovie(2014,"Teenage Mutant Ninja Turtles","Paramount Pictures, Nickelodeon Movies, Platinum Dunes","Michael Bay, Ian Bryce, Andrew Form, Bradley Fuller, Scott Mednick and Galen Walker",false,movieArgumentCaptorValue.get(178));
        verifyMovie(2014,"Transformers: Age of Extinction","Paramount Pictures","Ian Bryce, Tom DeSanto, Lorenzo di Bonaventura and Don Murphy",false,movieArgumentCaptorValue.get(179));
        verifyMovie(2015,"Fantastic Four","20th Century Fox","Simon Kinberg, Matthew Vaughn, Hutch Parker, Robert Kulzer and Gregory Goodman",true,movieArgumentCaptorValue.get(180));
        verifyMovie(2015,"Fifty Shades of Grey","Universal Pictures, Focus Features","Michael De Luca, Dana Brunetti and E. L. James",true,movieArgumentCaptorValue.get(181));
        verifyMovie(2015,"Jupiter Ascending","Warner Bros.","Grant Hill and The Wachowskis",false,movieArgumentCaptorValue.get(182));
        verifyMovie(2015,"Paul Blart: Mall Cop 2","Columbia Pictures","Todd Garner, Kevin James and Adam Sandler",false,movieArgumentCaptorValue.get(183));
        verifyMovie(2015,"Pixels","Columbia Pictures","Adam Sandler, Chris Columbus, Mark Radcliffe and Allen Covert",false,movieArgumentCaptorValue.get(184));
        verifyMovie(2016,"Hillary's America: The Secret History of the Democratic Party","Quality Flix","Gerald R. Molen",true,movieArgumentCaptorValue.get(185));
        verifyMovie(2016,"Batman v Superman: Dawn of Justice","Warner Bros.","Charles Roven and Deborah Snyder",false,movieArgumentCaptorValue.get(186));
        verifyMovie(2016,"Dirty Grandpa","Lionsgate","Bill Block, Michael Simkin, Jason Barrett and Barry Josephson",false,movieArgumentCaptorValue.get(187));
        verifyMovie(2016,"Gods of Egypt","Summit Entertainment","Basil Iwanyk and Alex Proyas",false,movieArgumentCaptorValue.get(188));
        verifyMovie(2016,"Independence Day: Resurgence","20th Century Fox","Dean Devlin, Harald Kloser and Roland Emmerich",false,movieArgumentCaptorValue.get(189));
        verifyMovie(2016,"Zoolander 2","Paramount Pictures","Stuart Cornfeld, Scott Rudin, Ben Stiller and Clayton Townsend",false,movieArgumentCaptorValue.get(190));
        verifyMovie(2017,"The Emoji Movie","Columbia Pictures","Michelle Raimo Kouyate",true,movieArgumentCaptorValue.get(191));
        verifyMovie(2017,"Baywatch","Paramount Pictures","Ivan Reitman, Michael Berk, Douglas Schwartz, Gregory J. Bonann and Beau Flynn",false,movieArgumentCaptorValue.get(192));
        verifyMovie(2017,"Fifty Shades Darker","Universal Pictures","Michael De Luca, E. L. James, Dana Brunetti and Marcus Viscidi",false,movieArgumentCaptorValue.get(193));
        verifyMovie(2017,"The Mummy","Universal Pictures","Alex Kurtzman, Chris Morgan, Sean Daniel and Sarah Bradshaw",false,movieArgumentCaptorValue.get(194));
        verifyMovie(2017,"Transformers: The Last Knight","Paramount Pictures","Don Murphy, Tom DeSanto, Lorenzo di Bonaventura and Ian Bryce",false,movieArgumentCaptorValue.get(195));
        verifyMovie(2018,"Holmes & Watson","Columbia Pictures","Will Ferrell, Adam McKay, Jimmy Miller and Clayton Townsend",true,movieArgumentCaptorValue.get(196));
        verifyMovie(2018,"Gotti","Vertical Entertainment","Randall Emmett, Marc Fiore, Michael Froch and George Furla",false,movieArgumentCaptorValue.get(197));
        verifyMovie(2018,"The Happytime Murders","STX","Ben Falcone, Jeffrey Hayes, Brian Henson and Melissa McCarthy",false,movieArgumentCaptorValue.get(198));
        verifyMovie(2018,"Robin Hood","Summit Entertainment","Jennifer Davisson and Leonardo DiCaprio",false,movieArgumentCaptorValue.get(199));
        verifyMovie(2018,"Winchester","Lionsgate","Tim McGahan and Brett Tomberlin",false,movieArgumentCaptorValue.get(200));
        verifyMovie(2019,"Cats","Universal Pictures","Debra Hayward, Tim Bevan, Eric Fellner, and Tom Hooper",true,movieArgumentCaptorValue.get(201));
        verifyMovie(2019,"The Fanatic","Quiver Distribution","Daniel Grodnik, Oscar Generale, and Bill Kenwright",false,movieArgumentCaptorValue.get(202));
        verifyMovie(2019,"The Haunting of Sharon Tate","Saban Films","Lucas Jarach, Daniel Farrands, and Eric Brenner",false,movieArgumentCaptorValue.get(203));
        verifyMovie(2019,"A Madea Family Funeral","Lionsgate","Ozzie Areu, Will Areu, and Mark E. Swinton",false,movieArgumentCaptorValue.get(204));
        verifyMovie(2019,"Rambo: Last Blood","Lionsgate","Avi Lerner, Kevin King Templeton, Yariv Lerner, and Les Weldon",false,movieArgumentCaptorValue.get(205));


    }


    private void verifyMovie(int year, String title, String studios, String producers, boolean winner, Movie movie){
        assertEquals(year,movie.getYear());
        assertEquals(title,movie.getTitle());
        assertEquals(studios,movie.getStudios());
        assertEquals(producers,movie.getProducers());
        assertEquals(winner,movie.getWinner());
    }

}
