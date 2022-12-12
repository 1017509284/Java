# ThreadLocal的用途
- 每个线程需要一个独享的对象（通常为工具类，例如SimpleDateFormat和Random）
- 每个线程内需要保存全局变量（例如在拦截器中获取用户信息，可以让不同方法直接使用，避免参数传递的麻烦）

# ThreadLocal作用
- 让某个需要用到的对象在线程间隔离（每个线程都有自己的独立的对象）
- 在任何方法中都可以轻松获取到该对象

# ThreadLocal带来的好处
- 达到线程安全
- 不需要加锁，提高执行效率
- 更高效的利用内存，节省开销
- 免去传参的繁琐