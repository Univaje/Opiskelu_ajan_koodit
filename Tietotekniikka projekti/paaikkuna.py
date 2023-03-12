from PyQt5.QtCore import *  # type: ignore
from PyQt5.QtGui import *  # type: ignore
from PyQt5.QtWidgets import *  # type: ignore
from functools import partial

# eri groupboxit/näkymät
from mittaus import Mittaus
from mittapohja import Mittapohja
from mittauspoytakirjat import MittausPoytaKirjat

# luo pääikkuna, jossa kaikki groupboxien luokat olioina valmiina
class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(600, 440)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.centralwidget.setMinimumSize(QSize(700, 400))
        self.formLayout = QFormLayout(self.centralwidget)
        self.formLayout.setObjectName(u"formLayout")
        self.formLayout.setHorizontalSpacing(2)
        self.formLayout.setVerticalSpacing(2)
        self.formLayout.setContentsMargins(9, 9, 9, 9)

        self.btnMittaPohja = QPushButton(self.centralwidget)
        self.btnMittaPohja.setObjectName(u"btnMittaPohja")
        self.formLayout.setWidget(3, QFormLayout.LabelRole, self.btnMittaPohja)

        self.btnMittaus = QPushButton(self.centralwidget)
        self.btnMittaus.setObjectName(u"btnMittaus")
        self.formLayout.setWidget(4, QFormLayout.LabelRole, self.btnMittaus)

        self.btnMittausPoytaKirjat = QPushButton(self.centralwidget)
        self.btnMittausPoytaKirjat.setObjectName(u"btnMittausPoytaKirjat")
        self.formLayout.setWidget(5, QFormLayout.LabelRole, self.btnMittausPoytaKirjat)
        

        self.gbMain = QGroupBox(self.centralwidget)
        self.gbMain.setObjectName(u"gbMain")
        self.mainLayout = QVBoxLayout(self.gbMain)
        self.mainLayout.setObjectName(u"verticalLayout")

        # käytä näitä olioita eri groupboxien näyttämiseen tai tietojen hakemiseen
        self.mittaus = Mittaus()
        self.mittapohja = Mittapohja()
        self.mittauspoytakirjat = MittausPoytaKirjat()

        # aseta metodit painikkeille groupboxien näyttämiseen
        self.btnMittaus.clicked.connect(partial(self.setMainGB, self.mittaus))
        self.btnMittausPoytaKirjat.clicked.connect(partial(self.setMainGB, self.mittauspoytakirjat))
        self.btnMittaPohja.clicked.connect(partial(self.setMainGB, self.mittapohja))

        self.formLayout.setWidget(0, QFormLayout.FieldRole, self.gbMain)

        MainWindow.setCentralWidget(self.centralwidget)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)
        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)


    # tyhjennä nykyinen layout ja aseta annettu groupbox siihen
    def setMainGB(self, obj):
        for i in reversed(range(self.mainLayout.count())): 
            self.mainLayout.itemAt(i).widget().setParent(None)
        self.mainLayout.addWidget(obj.gb)

    # jotain merkkijonoja, ei varmaan tarvetta muuttaa
    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.btnMittaus.setText(QCoreApplication.translate("MainWindow", u"Mittaus", None))
        self.btnMittausPoytaKirjat.setText(QCoreApplication.translate("MainWindow", u"Mittausp\u00f6yt\u00e4kirjat", None))
        self.btnMittaPohja.setText(QCoreApplication.translate("MainWindow", u"Mittapohja", None))
        self.gbMain.setTitle(QCoreApplication.translate("MainWindow", u"P\u00e4\u00e4n\u00e4kym\u00e4", None))