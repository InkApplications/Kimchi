package kimchi.logger

import kimchi.logger.android.AdbWriter

actual val defaultWriter: LogWriter = AdbWriter()
