from PyQt5.QtCore import *  # type: ignore
from PyQt5.QtGui import *  # type: ignore
import sys
from paaikkuna import *

# laita ikkunaksi paaikkunan Ui_MainWindow
class Window(QMainWindow, Ui_MainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setupUi(self)

# aja pääohjelma
if __name__ == "__main__":
    app = QApplication(sys.argv)
    win = Window()
    win.show()
    sys.exit(app.exec())
