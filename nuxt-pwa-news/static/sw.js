importScripts('/_nuxt/workbox.3de3418b.js')

const workboxSW = new self.WorkboxSW({
  "cacheId": "nuxt-pwa-news",
  "clientsClaim": true,
  "directoryIndex": "/"
})

workboxSW.precache([
  {
    "url": "/_nuxt/app.e5d14fffde1c27765bca.js",
    "revision": "84622fc0c1ed692157eddf6694fa55b3"
  },
  {
    "url": "/_nuxt/layouts/default.03729eb7ff0e1ecfd383.js",
    "revision": "dbe88eaed627a61867952c13450a1007"
  },
  {
    "url": "/_nuxt/manifest.01e2df59b43a758aa44b.js",
    "revision": "e65609743c38064e83a3afa0a4f04b57"
  },
  {
    "url": "/_nuxt/pages/index.e0d2fdb45f3e536172bf.js",
    "revision": "7348ad4ee3a2f59d28edefd12a531508"
  },
  {
    "url": "/_nuxt/vendor.53e70d06e11b29f6a8a8.js",
    "revision": "c8deedb6395edb9e01c51c3a63a21289"
  }
])


workboxSW.router.registerRoute(new RegExp('/_nuxt/.*'), workboxSW.strategies.cacheFirst({}), 'GET')

workboxSW.router.registerRoute(new RegExp('/.*'), workboxSW.strategies.networkFirst({}), 'GET')

