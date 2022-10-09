export default {

    isIOS(){
      return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },

    getUrlKey(name) {
        return decodeURIComponent((new RegExp('[?|&]'+name+'='+'([^&;]+?)(&|#|;|$)').exec(location.href)||[,""])[1].replace(/\+/g,'%20'))||null;
    },

    queryParams (data, isPrefix = false) {
        let prefix = isPrefix ? '?' : ''
        let _result = []
        for (let key in data) {
        let value = data[key]

        if (['', undefined, null].includes(value)) {
            continue
        }
        if (value.constructor === Array) {
            value.forEach(_value => {
            _result.push(encodeURIComponent(key) + '=' + encodeURIComponent(_value))
            })
        } else {
            _result.push(encodeURIComponent(key) + '=' + encodeURIComponent(value))
        }
        }

        return _result.length ? prefix + _result.join('&') : ''
    },

    deepClone(origin, target) {
        var target = target || {};
        target = JSON.parse(JSON.stringify(origin));
        return target;
    },
}
