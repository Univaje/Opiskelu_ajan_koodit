from PyQt5.QtCore import *  # type: ignore
from PyQt5.QtGui import *  # type: ignore
from PyQt5.QtWidgets import *  # type: ignore
from qt_utils import defaultItem, tkComboBox, tableWidgetData


class Mittaus():
  def __init__(self):
    # datan haku heti alkuun
    self.haeTilaukset()
    self.gbTyokalutPoistettu = True

    # tästä alaspäin vaan perus widgetit ja niiden ominaisuudet
    self.gb = QGroupBox()
    self.gb.setObjectName(u"gb")
    self.gb.setTitle("Mittaus")
    self.gb.setGeometry(QRect(10, 10, 591, 281))
    self.gridLayout = QGridLayout(self.gb)
    self.gridLayout.setObjectName(u"gridLayout")

    self.cbTilaus = QComboBox(self.gb)
    self.cbTilaus.setObjectName(u"cbTilaus")
    self.cbTilaus.setMaximumSize(QSize(200, 16777215))
    self.gridLayout.addWidget(self.cbTilaus, 0, 0, 1, 1)

    self.cbTilaus.activated.connect(self.luoTable)
    self.cbTilaus.addItems(self.tilaukset)
    self.cbTilaus.setCurrentIndex(-1)

    self.leKpl = QLineEdit(self.gb)
    self.leKpl.setObjectName(u"leKpl")
    self.leKpl.setPlaceholderText("Kpl")
    self.leKpl.setMaximumSize(QSize(100, 16777215))
    self.gridLayout.addWidget(self.leKpl, 3, 1, 1, 1)


    self.btnTallenna = QPushButton(self.gb)
    self.btnTallenna.setObjectName(u"btnTallenna")
    self.btnTallenna.setText(u"Tallenna")
    self.btnTallenna.setMaximumSize(QSize(100, 20))
    self.btnTallenna.clicked.connect(self.printtaaData)
    self.gridLayout.addWidget(self.btnTallenna, 4, 1, 1, 1)

  # singleton objekti
  def __new__(cls):
    if not hasattr(cls, 'instance'):
      cls.instance = super(Mittaus, cls).__new__(cls)
    return cls.instance

  # muokkaa hakemaan tietokannasta
  def haeTilaukset(self):
    self.tilaukset = ["tilaus1", "tilaus2", "tilaus3"]

  # DEMO  
  # Tulosta data taulukoista
  def printtaaData(self):
    try:
      print(f'Mittaukset: {tableWidgetData(self.twMittaukset)}')
      if not self.gbTyokalutPoistettu:
        print(f'Työkalut: {tableWidgetData(self.twTyokalut)}')
    except AttributeError:
      pass



  # muokkaa hakemaan tietokannasta
  def haeMittaPohja(self, tilaus):
    mittapohjat = { "tilaus1": [(1, 50.0, 0.05, "tk2"), (2, 45.0, 0.002, "tk1"), (3, 578.0, 0.1, "tk1"), (4, 123.0, 1.0, "tk3")],
                    "tilaus2": [(1, 10.0, 0.75), (2, 5.0, 0.07), (3, 80.0, 0.001)],
                    "tilaus3": [(1, 11.0, 0.55), (2, 1.0, 0.01), (3, 30.0, 0.01)]}
    self.mittapohja = mittapohjat.get(tilaus)

    if not self.gbTyokalutPoistettu:
      # poista nykyinen työkalu taulukko
      try: # laitetaan varmuudenvuoks tänne try exceptiin
        self.gbTyokalut.deleteLater() # poista nykynen gbTyokalut
        self.gbTyokalutPoistettu = True
      except AttributeError:
        pass

    # mikäli annetussa mittapohjassa ei ole työkaluja, ne pitää käyttäjän toimesta lisätä
    if len(self.mittapohja[0]) != 4:
      self.haeTyokalut(tilaus) # hae mahd. olemassa olevat työkalut
      self.luoTkTable()
    else:
      self.tyokalut = []



  
  # muokkaa hakemaan tietokannasta
  def haeTyokalut(self, tilaus):
    tyokalut = {"tilaus1": ["tk1", "tk2", "tk3"]}
    res = tyokalut.get(tilaus)
    if not res:
      res = []
    self.tyokalut = res

  def luoTable(self):
    self.haeMittaPohja(self.cbTilaus.currentText())
    self.twMittaukset = QTableWidget(self.gb)
    self.twMittaukset.setColumnCount(4)
    self.twMittaukset.setHorizontalHeaderLabels(["Työkalu", "Nominaalimitta", "Toleranssi", "Mittatulos"])
    for i,mitta in enumerate(self.mittapohja):
      self.lisaaMittausRivi(i, mitta)
    self.twMittaukset.setObjectName(u"twMittaukset")
    self.twMittaukset.setMaximumSize(QSize(16777215, 16777215))
    # disabloi sarakkeet
    for i in range(len(self.mittapohja)):
      item = self.twMittaukset.item(i, 1)
      item.setFlags(item.flags() & ~Qt.ItemIsEditable)
      item = self.twMittaukset.item(i, 2)
      item.setFlags(item.flags() & ~Qt.ItemIsEditable)

    self.gridLayout.addWidget(self.twMittaukset, 1, 0, 1, 1)

  # lisää rivi mittaus taulukkoon
  def lisaaMittausRivi(self, i, mitta):
    self.twMittaukset.insertRow(i) 
    self.twMittaukset.setItem(i, 1, defaultItem(mitta[1])) # nominaalimitta
    self.twMittaukset.setItem(i, 2, defaultItem(mitta[2])) # toleranssi
    self.twMittaukset.setItem(i, 3, defaultItem()) # mittatulos

    # aseta työkalu sarakkeelle nominaalimitalle asetettu työkalu, jos ei löydy niin aseta combobox
    try:
      item = QTableWidgetItem(mitta[3])
      item.setFlags(item.flags() & ~Qt.ItemIsEditable)
      self.twMittaukset.setItem(i, 0, item)
    except IndexError:
      self.twMittaukset.setCellWidget(i, 0, tkComboBox(self.tyokalut))


  # luo työkalu taulu groupboxissa
  def luoTkTable(self):
    self.gbTyokalutPoistettu = False
    self.tkSpinBoxes = []
    self.gbTyokalut = QGroupBox(self.gb)
    self.gbTyokalut.setObjectName(u"gbTyokalut")
    self.gbTyokalut.setTitle("Kappaleen työkalut")
    self.gbTyokalut.setGeometry(QRect(10, 10, 591, 281))
    gridLayout = QGridLayout(self.gbTyokalut)
    gridLayout.setObjectName(u"gridLayout")
    self.twTyokalut = QTableWidget(self.gbTyokalut)
    self.twTyokalut.setRowCount(0)
    self.twTyokalut.setColumnCount(3)
    self.twTyokalut.setHorizontalHeaderLabels(["Työkalu", "Kohdemuuttuja D", "Kohdemuuttuja L"])
    self.lisaaTkRivi()

    self.twTyokalut.setObjectName(u"twMittaukset")
    self.twTyokalut.setMaximumSize(QSize(16777215, 16777215))
    gridLayout.addWidget(self.twTyokalut, 0, 0, 1, 1)
  
    self.btnLisaaRivi = QPushButton(self.gbTyokalut)
    self.btnLisaaRivi.setObjectName(u"btnLisaaRivi")
    self.btnLisaaRivi.setText(u"Lisää Rivi")
    self.btnLisaaRivi.setMaximumSize(QSize(100, 20))
    gridLayout.addWidget(self.btnLisaaRivi, 2, 0, 1, 1)
    self.btnLisaaRivi.clicked.connect(self.lisaaTkRivi)

    self.gridLayout.addWidget(self.gbTyokalut, 2, 0, 1, 1)

  # lisää rivi työkalu taulukkoon
  def lisaaTkRivi(self):
    rowPosition = self.twTyokalut.rowCount()
    self.twTyokalut.insertRow(rowPosition)
    self.twTyokalut.setCellWidget(rowPosition, 0, self.uniqueSpinBox(rowPosition))
    self.twTyokalut.setItem(rowPosition, 1, QTableWidgetItem())
    self.twTyokalut.setItem(rowPosition, 2, QTableWidgetItem())

  # palauta spinbox olio, joka on sidottuna tkSpinBoxes kokoelmaan vaatimaan niiden kesken uniikki arvo
  def uniqueSpinBox(self, row):
    sb = QSpinBox()
    sb.valueChanged.connect(lambda value, row=row: self.varmistaTkUniikkius(value, row))
    self.tkSpinBoxes.append(sb)
    return sb
        
  # kato että annettu arvo on juuri siinä mille se annettiin, muuten laske arvo yhdellä ja toista kunnes homma pelaa
  # päivitä mittaustaulun comboboxit joka kerta kun jotain näistä spinboxeista muutetaan
  def varmistaTkUniikkius(self, value, row):
    for i, sb in enumerate(self.tkSpinBoxes):
      if i == row and sb.value() == 0:
        break
      elif i != row and sb.value() == value:
        self.tkSpinBoxes[row].setValue(self.tkSpinBoxes[row].value() + 1)
        break
    self.paivitaTkComboboxit([f'tk{sb.value()}' for sb in self.tkSpinBoxes if sb.value() != 0])

  # päivitä nykyiseen mittaustauluun työkalu comboboxeille arvot 
  def paivitaTkComboboxit(self, data):
    self.tyokalut = data
    for row in range(self.twMittaukset.rowCount()):
      cb = self.twMittaukset.cellWidget(row, 0)
      cb.clear()
      cb.addItems(self.tyokalut)

