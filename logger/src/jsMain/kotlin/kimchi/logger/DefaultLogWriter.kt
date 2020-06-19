package kimchi.logger

import kimchi.logger.js.ConsoleWriter

actual val defaultWriter: LogWriter = ConsoleWriter
