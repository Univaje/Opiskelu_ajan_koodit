from PyQt5.QtCore import *  # type: ignore
from PyQt5.QtGui import *  # type: ignore
from PyQt5.QtWidgets import *  # type: ignore
from qt_utils import defaultItem

class Mittapohja():
  def __init__(self):
    self.gb = QGroupBox()
    self.gb.setObjectName(u"gb")
    self.gb.setTitle("Mittapohja")
    self.gb.setGeometry(QRect(10, 10, 591, 281))
    self.gridLayout = QGridLayout(self.gb)
    self.gridLayout.setObjectName(u"gridLayout")

    self.lineEdit = QLineEdit(self.gb)
    self.lineEdit.setObjectName(u"lineEdit")
    self.lineEdit.setMaximumSize(QSize(200, 16777215))
    self.gridLayout.addWidget(self.lineEdit, 0, 0, 1, 1)

    self.luoTable(self.gb)

    self.btnLisaaRivi = QPushButton(self.gb)
    self.btnLisaaRivi.setObjectName(u"btnLisaaRivi")
    self.btnLisaaRivi.setText(u"Lisää Rivi")
    self.btnLisaaRivi.setMaximumSize(QSize(100, 20))
    self.gridLayout.addWidget(self.btnLisaaRivi, 2, 0, 1, 1)
    self.btnLisaaRivi.clicked.connect(self.lisaaRivi)

    self.verticalSpacer = QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Fixed)
    self.gridLayout.addItem(self.verticalSpacer, 3, 0, 1, 1)

    self.btnPoistu = QPushButton(self.gb)
    self.btnPoistu.setObjectName(u"btnPoistu")
    self.btnPoistu.setText(u"Poistu")
    self.btnPoistu.setMaximumSize(QSize(70, 16777215))
    self.gridLayout.addWidget(self.btnPoistu, 3, 0, 1, 1)

    self.btnTallenna = QPushButton(self.gb)
    self.btnTallenna.setObjectName(u"btnTallenna")
    self.btnTallenna.setText(u"Tallenna")
    self.btnTallenna.setMaximumSize(QSize(100, 20))
    self.gridLayout.addWidget(self.btnTallenna, 3, 1, 1, 1)



  def __new__(cls):
    if not hasattr(cls, 'instance'):
      cls.instance = super(Mittapohja, cls).__new__(cls)
    return cls.instance

  # luo excelmäinen taulukko mittojen asettamiseen
  def luoTable(self, parent):
    self.twMittaukset = QTableWidget(parent)
    self.twMittaukset.setRowCount(3)
    self.twMittaukset.setColumnCount(2)
    self.twMittaukset.setHorizontalHeaderLabels(["Nominaalimitta", "Toleranssi"])
    for i in range(3):
      self.twMittaukset.setItem(i, 0, defaultItem())
      self.twMittaukset.setItem(i, 1, defaultItem())

    self.twMittaukset.setObjectName(u"twMittaukset")
    self.twMittaukset.setMaximumSize(QSize(16777215, 16777215))
    self.gridLayout.addWidget(self.twMittaukset, 1, 0, 1, 1)

  # lisää rivi nykyiseen taulukkoon
  def lisaaRivi(self):
    rowPosition = self.twMittaukset.rowCount()
    self.twMittaukset.insertRow(rowPosition)
    self.twMittaukset.setItem(rowPosition, 0, defaultItem())
    self.twMittaukset.setItem(rowPosition, 1, defaultItem())

