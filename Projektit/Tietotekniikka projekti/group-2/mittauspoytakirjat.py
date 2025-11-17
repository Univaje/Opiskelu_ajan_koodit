from PyQt5.QtCore import *  # type: ignore
from PyQt5.QtGui import *  # type: ignore
from PyQt5.QtWidgets import *  # type: ignore

class MittausPoytaKirjat():
  def __init__(self):
    self.gb = QGroupBox()
    self.gb.setObjectName(u"gb")
    self.gb.setTitle("Mittauspoytakirjat")
    self.gb.setGeometry(QRect(10, 10, 591, 291))
    self.gridLayout = QGridLayout(self.gb)
    self.gridLayout.setObjectName(u"gridLayout")

    self.btnPoistu = QPushButton(self.gb)
    self.btnPoistu.setObjectName(u"btnPoistu")
    self.btnPoistu.setText(u"Poistu")
    self.btnPoistu.setMaximumSize(QSize(70, 16777215))
    self.gridLayout.addWidget(self.btnPoistu, 1, 0, 1, 1)

    self.btnVie = QPushButton(self.gb)
    self.btnVie.setObjectName(u"btnVie")
    self.btnVie.setText(u"Vie")
    self.btnVie.setMaximumSize(QSize(100, 20))
    self.gridLayout.addWidget(self.btnVie, 1, 1, 1, 1)

    data = ['Tilaus 1', 'Tilaus 2', 'Tilaus 3']
    self.lwMittausPoytaKirjat = self.luoLista(data)
    self.lwMittausPoytaKirjat.setObjectName(u"lwMittausPoytaKirjat")
    self.gridLayout.addWidget(self.lwMittausPoytaKirjat, 0, 0, 1, 1)

  def __new__(cls):
    if not hasattr(cls, 'instance'):
      cls.instance = super(MittausPoytaKirjat, cls).__new__(cls)
    return cls.instance

  # luo lista ja aseta yksittäisille itemeille testi funktio
  def luoLista(self, data):
    model = QStandardItemModel()
    for item in data:
      model.appendRow(QStandardItem(item))
    lw = QListView()
    lw.setModel(model)
    lw.clicked.connect(lambda index: print("Item clicked:", model.itemFromIndex(index).text()))
    return lw
