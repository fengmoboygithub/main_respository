/*!
 * Select2 4.0.3
 * https://select2.github.io
 *
 * Released under the MIT license
 * https://github.com/select2/select2/blob/master/LICENSE.md
 */
(function (a) {
    if (typeof define === "function" && define.amd) {
        define(["jquery"], a)
    } else {
        if (typeof exports === "object") {
            a(require("jquery"))
        } else {
            a(jQuery)
        }
    }
}(function (c) {
    var b = (function () {
        if (c && c.fn && c.fn.select2 && c.fn.select2.amd) {
            var d = c.fn.select2.amd
        }
        var d;
        (function () {
            if (!d || !d.requirejs) {
                if (!d) {
                    d = {}
                } else {
                    e = d
                }
                var f, e, g;
                (function (l) {
                    var o, h, s, t, k = {}, j = {}, z = {}, w = {}, r = Object.prototype.hasOwnProperty, p = [].slice,
                        q = /\.js$/;

                    function A(B, C) {
                        return r.call(B, C)
                    }

                    function u(E, C) {
                        var M, I, G, J, N, F, P, Q, L, K, H, O = C && C.split("/"), D = z.map, B = (D && D["*"]) || {};
                        if (E && E.charAt(0) === ".") {
                            if (C) {
                                E = E.split("/");
                                N = E.length - 1;
                                if (z.nodeIdCompat && q.test(E[N])) {
                                    E[N] = E[N].replace(q, "")
                                }
                                E = O.slice(0, O.length - 1).concat(E);
                                for (L = 0; L < E.length; L += 1) {
                                    H = E[L];
                                    if (H === ".") {
                                        E.splice(L, 1);
                                        L -= 1
                                    } else {
                                        if (H === "..") {
                                            if (L === 1 && (E[2] === ".." || E[0] === "..")) {
                                                break
                                            } else {
                                                if (L > 0) {
                                                    E.splice(L - 1, 2);
                                                    L -= 2
                                                }
                                            }
                                        }
                                    }
                                }
                                E = E.join("/")
                            } else {
                                if (E.indexOf("./") === 0) {
                                    E = E.substring(2)
                                }
                            }
                        }
                        if ((O || B) && D) {
                            M = E.split("/");
                            for (L = M.length; L > 0; L -= 1) {
                                I = M.slice(0, L).join("/");
                                if (O) {
                                    for (K = O.length; K > 0; K -= 1) {
                                        G = D[O.slice(0, K).join("/")];
                                        if (G) {
                                            G = G[I];
                                            if (G) {
                                                J = G;
                                                F = L;
                                                break
                                            }
                                        }
                                    }
                                }
                                if (J) {
                                    break
                                }
                                if (!P && B && B[I]) {
                                    P = B[I];
                                    Q = L
                                }
                            }
                            if (!J && P) {
                                J = P;
                                F = Q
                            }
                            if (J) {
                                M.splice(0, F, J);
                                E = M.join("/")
                            }
                        }
                        return E
                    }

                    function y(B, C) {
                        return function () {
                            var D = p.call(arguments, 0);
                            if (typeof D[0] !== "string" && D.length === 1) {
                                D.push(null)
                            }
                            return h.apply(l, D.concat([B, C]))
                        }
                    }

                    function v(B) {
                        return function (C) {
                            return u(C, B)
                        }
                    }

                    function m(B) {
                        return function (C) {
                            k[B] = C
                        }
                    }

                    function n(C) {
                        if (A(j, C)) {
                            var B = j[C];
                            delete j[C];
                            w[C] = true;
                            o.apply(l, B)
                        }
                        if (!A(k, C) && !A(w, C)) {
                            throw new Error("No " + C)
                        }
                        return k[C]
                    }

                    function x(C) {
                        var D, B = C ? C.indexOf("!") : -1;
                        if (B > -1) {
                            D = C.substring(0, B);
                            C = C.substring(B + 1, C.length)
                        }
                        return [D, C]
                    }

                    s = function (C, B) {
                        var D, F = x(C), E = F[0];
                        C = F[1];
                        if (E) {
                            E = u(E, B);
                            D = n(E)
                        }
                        if (E) {
                            if (D && D.normalize) {
                                C = D.normalize(C, v(B))
                            } else {
                                C = u(C, B)
                            }
                        } else {
                            C = u(C, B);
                            F = x(C);
                            E = F[0];
                            C = F[1];
                            if (E) {
                                D = n(E)
                            }
                        }
                        return {f: E ? E + "!" + C : C, n: C, pr: E, p: D}
                    };

                    function i(B) {
                        return function () {
                            return (z && z.config && z.config[B]) || {}
                        }
                    }

                    t = {
                        require: function (B) {
                            return y(B)
                        }, exports: function (B) {
                            var C = k[B];
                            if (typeof C !== "undefined") {
                                return C
                            } else {
                                return (k[B] = {})
                            }
                        }, module: function (B) {
                            return {id: B, uri: "", exports: k[B], config: i(B)}
                        }
                    };
                    o = function (C, M, L, K) {
                        var F, J, G, B, E, H = [], D = typeof L, I;
                        K = K || C;
                        if (D === "undefined" || D === "function") {
                            M = !M.length && L.length ? ["require", "exports", "module"] : M;
                            for (E = 0; E < M.length; E += 1) {
                                B = s(M[E], K);
                                J = B.f;
                                if (J === "require") {
                                    H[E] = t.require(C)
                                } else {
                                    if (J === "exports") {
                                        H[E] = t.exports(C);
                                        I = true
                                    } else {
                                        if (J === "module") {
                                            F = H[E] = t.module(C)
                                        } else {
                                            if (A(k, J) || A(j, J) || A(w, J)) {
                                                H[E] = n(J)
                                            } else {
                                                if (B.p) {
                                                    B.p.load(B.n, y(K, true), m(J), {});
                                                    H[E] = k[J]
                                                } else {
                                                    throw new Error(C + " missing " + J)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            G = L ? L.apply(k[C], H) : undefined;
                            if (C) {
                                if (F && F.exports !== l && F.exports !== k[C]) {
                                    k[C] = F.exports
                                } else {
                                    if (G !== l || !I) {
                                        k[C] = G
                                    }
                                }
                            }
                        } else {
                            if (C) {
                                k[C] = L
                            }
                        }
                    };
                    f = e = h = function (E, F, B, C, D) {
                        if (typeof E === "string") {
                            if (t[E]) {
                                return t[E](F)
                            }
                            return n(s(E, F).f)
                        } else {
                            if (!E.splice) {
                                z = E;
                                if (z.deps) {
                                    h(z.deps, z.callback)
                                }
                                if (!F) {
                                    return
                                }
                                if (F.splice) {
                                    E = F;
                                    F = B;
                                    B = null
                                } else {
                                    E = l
                                }
                            }
                        }
                        F = F || function () {
                        };
                        if (typeof B === "function") {
                            B = C;
                            C = D
                        }
                        if (C) {
                            o(l, E, F, B)
                        } else {
                            setTimeout(function () {
                                o(l, E, F, B)
                            }, 4)
                        }
                        return h
                    };
                    h.config = function (B) {
                        return h(B)
                    };
                    f._defined = k;
                    g = function (B, C, D) {
                        if (typeof B !== "string") {
                            throw new Error("See almond README: incorrect module build, no module name")
                        }
                        if (!C.splice) {
                            D = C;
                            C = []
                        }
                        if (!A(k, B) && !A(j, B)) {
                            j[B] = [B, C, D]
                        }
                    };
                    g.amd = {jQuery: true}
                }());
                d.requirejs = f;
                d.require = e;
                d.define = g
            }
        }());
        d.define("almond", function () {
        });
        d.define("jquery", [], function () {
            var e = c || $;
            if (e == null && console && console.error) {
                console.error("Select2: An instance of jQuery or a jQuery-compatible library was not found. Make sure that you are including jQuery before Select2 on your web page.")
            }
            return e
        });
        d.define("select2/utils", ["jquery"], function (h) {
            var g = {};
            g.Extend = function (m, j) {
                var k = {}.hasOwnProperty;

                function i() {
                    this.constructor = m
                }

                for (var l in j) {
                    if (k.call(j, l)) {
                        m[l] = j[l]
                    }
                }
                i.prototype = j.prototype;
                m.prototype = new i();
                m.__super__ = j.prototype;
                return m
            };

            function f(n) {
                var l = n.prototype;
                var k = [];
                for (var j in l) {
                    var i = l[j];
                    if (typeof i !== "function") {
                        continue
                    }
                    if (j === "constructor") {
                        continue
                    }
                    k.push(j)
                }
                return k
            }

            g.Decorate = function (q, p) {
                var o = f(p);
                var n = f(q);

                function t() {
                    var u = Array.prototype.unshift;
                    var v = p.prototype.constructor.length;
                    var m = q.prototype.constructor;
                    if (v > 0) {
                        u.call(arguments, q.prototype.constructor);
                        m = p.prototype.constructor
                    }
                    m.apply(this, arguments)
                }

                p.displayName = q.displayName;

                function i() {
                    this.constructor = t
                }

                t.prototype = new i();
                for (var l = 0; l < n.length; l++) {
                    var j = n[l];
                    t.prototype[j] = q.prototype[j]
                }
                var s = function (m) {
                    var u = function () {
                    };
                    if (m in t.prototype) {
                        u = t.prototype[m]
                    }
                    var v = p.prototype[m];
                    return function () {
                        var w = Array.prototype.unshift;
                        w.call(arguments, u);
                        return v.apply(this, arguments)
                    }
                };
                for (var r = 0; r < o.length; r++) {
                    var k = o[r];
                    t.prototype[k] = s(k)
                }
                return t
            };
            var e = function () {
                this.listeners = {}
            };
            e.prototype.on = function (i, j) {
                this.listeners = this.listeners || {};
                if (i in this.listeners) {
                    this.listeners[i].push(j)
                } else {
                    this.listeners[i] = [j]
                }
            };
            e.prototype.trigger = function (i) {
                var k = Array.prototype.slice;
                var j = k.call(arguments, 1);
                this.listeners = this.listeners || {};
                if (j == null) {
                    j = []
                }
                if (j.length === 0) {
                    j.push({})
                }
                j[0]._type = i;
                if (i in this.listeners) {
                    this.invoke(this.listeners[i], k.call(arguments, 1))
                }
                if ("*" in this.listeners) {
                    this.invoke(this.listeners["*"], arguments)
                }
            };
            e.prototype.invoke = function (l, m) {
                for (var k = 0, j = l.length; k < j; k++) {
                    l[k].apply(this, m)
                }
            };
            g.Observable = e;
            g.generateChars = function (m) {
                var l = "";
                for (var k = 0; k < m; k++) {
                    var j = Math.floor(Math.random() * 36);
                    l += j.toString(36)
                }
                return l
            };
            g.bind = function (j, i) {
                return function () {
                    j.apply(i, arguments)
                }
            };
            g._convertData = function (o) {
                for (var n in o) {
                    var m = n.split("-");
                    var i = o;
                    if (m.length === 1) {
                        continue
                    }
                    for (var j = 0; j < m.length; j++) {
                        var l = m[j];
                        l = l.substring(0, 1).toLowerCase() + l.substring(1);
                        if (!(l in i)) {
                            i[l] = {}
                        }
                        if (j == m.length - 1) {
                            i[l] = o[n]
                        }
                        i = i[l]
                    }
                    delete o[n]
                }
                return o
            };
            g.hasScroll = function (k, m) {
                var l = h(m);
                var j = m.style.overflowX;
                var i = m.style.overflowY;
                if (j === i && (i === "hidden" || i === "visible")) {
                    return false
                }
                if (j === "scroll" || i === "scroll") {
                    return true
                }
                return (l.innerHeight() < m.scrollHeight || l.innerWidth() < m.scrollWidth)
            };
            g.escapeMarkup = function (i) {
                var j = {
                    "\\": "&#92;",
                    "&": "&amp;",
                    "<": "&lt;",
                    ">": "&gt;",
                    '"': "&quot;",
                    "'": "&#39;",
                    "/": "&#47;"
                };
                if (typeof i !== "string") {
                    return i
                }
                return String(i).replace(/[&<>"'\/\\]/g, function (k) {
                    return j[k]
                })
            };
            g.appendMany = function (i, k) {
                if (h.fn.jquery.substr(0, 3) === "1.7") {
                    var j = h();
                    h.map(k, function (l) {
                        j = j.add(l)
                    });
                    k = j
                }
                i.append(k)
            };
            return g
        });
        d.define("select2/results", ["jquery", "./utils"], function (g, f) {
            function e(h, i, j) {
                this.$element = h;
                this.data = j;
                this.options = i;
                e.__super__.constructor.call(this)
            }

            f.Extend(e, f.Observable);
            e.prototype.render = function () {
                var h = g('<ul class="select2-results__options" role="tree"></ul>');
                if (this.options.get("multiple")) {
                    h.attr("aria-multiselectable", "true")
                }
                this.$results = h;
                return h
            };
            e.prototype.clear = function () {
                this.$results.empty()
            };
            e.prototype.displayMessage = function (k) {
                var h = this.options.get("escapeMarkup");
                this.clear();
                this.hideLoading();
                var i = g('<li role="treeitem" aria-live="assertive" class="select2-results__option"></li>');
                var j = this.options.get("translations").get(k.message);
                i.append(h(j(k.args)));
                i[0].className += " select2-results__message";
                this.$results.append(i)
            };
            e.prototype.hideMessages = function () {
                this.$results.find(".select2-results__message").remove()
            };
            e.prototype.append = function (j) {
                this.hideLoading();
                var h = [];
                if (j.results == null || j.results.length === 0) {
                    if (this.$results.children().length === 0) {
                        this.trigger("results:message", {message: "noResults"})
                    }
                    return
                }
                j.results = this.sort(j.results);
                for (var l = 0; l < j.results.length; l++) {
                    var i = j.results[l];
                    var k = this.option(i);
                    h.push(k)
                }
                this.$results.append(h)
            };
            e.prototype.position = function (h, i) {
                var j = i.find(".select2-results");
                j.append(h)
            };
            e.prototype.sort = function (h) {
                var i = this.options.get("sorter");
                return i(h)
            };
            e.prototype.highlightFirstItem = function () {
                var h = this.$results.find(".select2-results__option[aria-selected]");
                var i = h.filter("[aria-selected=true]");
                if (i.length > 0) {
                    i.first().trigger("mouseenter")
                } else {
                    h.first().trigger("mouseenter")
                }
                this.ensureHighlightVisible()
            };
            e.prototype.setClasses = function () {
                var h = this;
                this.data.current(function (k) {
                    var j = g.map(k, function (l) {
                        return l.id.toString()
                    });
                    var i = h.$results.find(".select2-results__option[aria-selected]");
                    i.each(function () {
                        var m = g(this);
                        var l = g.data(this, "data");
                        var n = "" + l.id;
                        if ((l.element != null && l.element.selected) || (l.element == null && g.inArray(n, j) > -1)) {
                            m.attr("aria-selected", "true")
                        } else {
                            m.attr("aria-selected", "false")
                        }
                    })
                })
            };
            e.prototype.showLoading = function (j) {
                this.hideLoading();
                var i = this.options.get("translations").get("searching");
                var k = {disabled: true, loading: true, text: i(j)};
                var h = this.option(k);
                h.className += " loading-results";
                this.$results.prepend(h)
            };
            e.prototype.hideLoading = function () {
                this.$results.find(".loading-results").remove()
            };
            e.prototype.option = function (l) {
                var m = document.createElement("li");
                m.className = "select2-results__option";
                var t = {role: "treeitem", "aria-selected": "false"};
                if (l.disabled) {
                    delete t["aria-selected"];
                    t["aria-disabled"] = "true"
                }
                if (l.id == null) {
                    delete t["aria-selected"]
                }
                if (l._resultId != null) {
                    m.id = l._resultId
                }
                if (l.title) {
                    m.title = l.title
                }
                if (l.children) {
                    t.role = "group";
                    t["aria-label"] = l.text;
                    delete t["aria-selected"]
                }
                for (var n in t) {
                    var k = t[n];
                    m.setAttribute(n, k)
                }
                if (l.children) {
                    var h = g(m);
                    var r = document.createElement("strong");
                    r.className = "select2-results__group";
                    var q = g(r);
                    this.template(l, r);
                    var s = [];
                    for (var p = 0; p < l.children.length; p++) {
                        var j = l.children[p];
                        var i = this.option(j);
                        s.push(i)
                    }
                    var o = g("<ul></ul>", {"class": "select2-results__options select2-results__options--nested"});
                    o.append(s);
                    h.append(r);
                    h.append(o)
                } else {
                    this.template(l, m)
                }
                g.data(m, "data", l);
                return m
            };
            e.prototype.bind = function (h, j) {
                var i = this;
                var k = h.id + "-results";
                this.$results.attr("id", k);
                h.on("results:all", function (l) {
                    i.clear();
                    i.append(l.data);
                    if (h.isOpen()) {
                        i.setClasses();
                        i.highlightFirstItem()
                    }
                });
                h.on("results:append", function (l) {
                    i.append(l.data);
                    if (h.isOpen()) {
                        i.setClasses()
                    }
                });
                h.on("query", function (l) {
                    i.hideMessages();
                    i.showLoading(l)
                });
                h.on("select", function () {
                    if (!h.isOpen()) {
                        return
                    }
                    i.setClasses();
                    i.highlightFirstItem()
                });
                h.on("unselect", function () {
                    if (!h.isOpen()) {
                        return
                    }
                    i.setClasses();
                    i.highlightFirstItem()
                });
                h.on("open", function () {
                    i.$results.attr("aria-expanded", "true");
                    i.$results.attr("aria-hidden", "false");
                    i.setClasses();
                    i.ensureHighlightVisible()
                });
                h.on("close", function () {
                    i.$results.attr("aria-expanded", "false");
                    i.$results.attr("aria-hidden", "true");
                    i.$results.removeAttr("aria-activedescendant")
                });
                h.on("results:toggle", function () {
                    var l = i.getHighlightedResults();
                    if (l.length === 0) {
                        return
                    }
                    l.trigger("mouseup")
                });
                h.on("results:select", function () {
                    var l = i.getHighlightedResults();
                    if (l.length === 0) {
                        return
                    }
                    var m = l.data("data");
                    if (l.attr("aria-selected") == "true") {
                        i.trigger("close", {})
                    } else {
                        i.trigger("select", {data: m})
                    }
                });
                h.on("results:previous", function () {
                    var n = i.getHighlightedResults();
                    var m = i.$results.find("[aria-selected]");
                    var p = m.index(n);
                    if (p === 0) {
                        return
                    }
                    var l = p - 1;
                    if (n.length === 0) {
                        l = 0
                    }
                    var o = m.eq(l);
                    o.trigger("mouseenter");
                    var s = i.$results.offset().top;
                    var r = o.offset().top;
                    var q = i.$results.scrollTop() + (r - s);
                    if (l === 0) {
                        i.$results.scrollTop(0)
                    } else {
                        if (r - s < 0) {
                            i.$results.scrollTop(q)
                        }
                    }
                });
                h.on("results:next", function () {
                    var n = i.getHighlightedResults();
                    var m = i.$results.find("[aria-selected]");
                    var p = m.index(n);
                    var l = p + 1;
                    if (l >= m.length) {
                        return
                    }
                    var o = m.eq(l);
                    o.trigger("mouseenter");
                    var s = i.$results.offset().top + i.$results.outerHeight(false);
                    var r = o.offset().top + o.outerHeight(false);
                    var q = i.$results.scrollTop() + r - s;
                    if (l === 0) {
                        i.$results.scrollTop(0)
                    } else {
                        if (r > s) {
                            i.$results.scrollTop(q)
                        }
                    }
                });
                h.on("results:focus", function (l) {
                    l.element.addClass("select2-results__option--highlighted")
                });
                h.on("results:message", function (l) {
                    i.displayMessage(l)
                });
                if (g.fn.mousewheel) {
                    this.$results.on("mousewheel", function (o) {
                        var n = i.$results.scrollTop();
                        var l = i.$results.get(0).scrollHeight - n + o.deltaY;
                        var p = o.deltaY > 0 && n - o.deltaY <= 0;
                        var m = o.deltaY < 0 && l <= i.$results.height();
                        if (p) {
                            i.$results.scrollTop(0);
                            o.preventDefault();
                            o.stopPropagation()
                        } else {
                            if (m) {
                                i.$results.scrollTop(i.$results.get(0).scrollHeight - i.$results.height());
                                o.preventDefault();
                                o.stopPropagation()
                            }
                        }
                    })
                }
                this.$results.on("mouseup", ".select2-results__option[aria-selected]", function (l) {
                    var n = g(this);
                    var m = n.data("data");
                    if (n.attr("aria-selected") === "true") {
                        if (i.options.get("multiple")) {
                            i.trigger("unselect", {originalEvent: l, data: m})
                        } else {
                            i.trigger("close", {})
                        }
                        return
                    }
                    i.trigger("select", {originalEvent: l, data: m})
                });
                this.$results.on("mouseenter", ".select2-results__option[aria-selected]", function (l) {
                    var m = g(this).data("data");
                    i.getHighlightedResults().removeClass("select2-results__option--highlighted");
                    i.trigger("results:focus", {data: m, element: g(this)})
                })
            };
            e.prototype.getHighlightedResults = function () {
                var h = this.$results.find(".select2-results__option--highlighted");
                return h
            };
            e.prototype.destroy = function () {
                this.$results.remove()
            };
            e.prototype.ensureHighlightVisible = function () {
                var i = this.getHighlightedResults();
                if (i.length === 0) {
                    return
                }
                var h = this.$results.find("[aria-selected]");
                var j = h.index(i);
                var m = this.$results.offset().top;
                var l = i.offset().top;
                var k = this.$results.scrollTop() + (l - m);
                var n = l - m;
                k -= i.outerHeight(false) * 2;
                if (j <= 2) {
                    this.$results.scrollTop(0)
                } else {
                    if (n > this.$results.outerHeight() || n < 0) {
                        this.$results.scrollTop(k)
                    }
                }
            };
            e.prototype.template = function (i, j) {
                var k = this.options.get("templateResult");
                var h = this.options.get("escapeMarkup");
                var l = k(i, j);
                if (l == null) {
                    j.style.display = "none"
                } else {
                    if (typeof l === "string") {
                        j.innerHTML = h(l)
                    } else {
                        g(j).append(l)
                    }
                }
            };
            return e
        });
        d.define("select2/keys", [], function () {
            var e = {
                BACKSPACE: 8,
                TAB: 9,
                ENTER: 13,
                SHIFT: 16,
                CTRL: 17,
                ALT: 18,
                ESC: 27,
                SPACE: 32,
                PAGE_UP: 33,
                PAGE_DOWN: 34,
                END: 35,
                HOME: 36,
                LEFT: 37,
                UP: 38,
                RIGHT: 39,
                DOWN: 40,
                DELETE: 46
            };
            return e
        });
        d.define("select2/selection/base", ["jquery", "../utils", "../keys"], function (h, g, e) {
            function f(i, j) {
                this.$element = i;
                this.options = j;
                f.__super__.constructor.call(this)
            }

            g.Extend(f, g.Observable);
            f.prototype.render = function () {
                var i = h('<span class="select2-selection" role="combobox"  aria-haspopup="true" aria-expanded="false"></span>');
                this._tabindex = 0;
                if (this.$element.data("old-tabindex") != null) {
                    this._tabindex = this.$element.data("old-tabindex")
                } else {
                    if (this.$element.attr("tabindex") != null) {
                        this._tabindex = this.$element.attr("tabindex")
                    }
                }
                i.attr("title", this.$element.attr("title"));
                i.attr("tabindex", this._tabindex);
                this.$selection = i;
                return i
            };
            f.prototype.bind = function (i, l) {
                var k = this;
                var m = i.id + "-container";
                var j = i.id + "-results";
                this.container = i;
                this.$selection.on("focus", function (n) {
                    k.trigger("focus", n)
                });
                this.$selection.on("blur", function (n) {
                    k._handleBlur(n)
                });
                this.$selection.on("keydown", function (n) {
                    k.trigger("keypress", n);
                    if (n.which === e.SPACE) {
                        n.preventDefault()
                    }
                });
                i.on("results:focus", function (n) {
                    k.$selection.attr("aria-activedescendant", n.data._resultId)
                });
                i.on("selection:update", function (n) {
                    k.update(n.data)
                });
                i.on("open", function () {
                    k.$selection.attr("aria-expanded", "true");
                    k.$selection.attr("aria-owns", j);
                    k._attachCloseHandler(i)
                });
                i.on("close", function () {
                    k.$selection.attr("aria-expanded", "false");
                    k.$selection.removeAttr("aria-activedescendant");
                    k.$selection.removeAttr("aria-owns");
                    k.$selection.focus();
                    k._detachCloseHandler(i)
                });
                i.on("enable", function () {
                    k.$selection.attr("tabindex", k._tabindex)
                });
                i.on("disable", function () {
                    k.$selection.attr("tabindex", "-1")
                })
            };
            f.prototype._handleBlur = function (i) {
                var j = this;
                window.setTimeout(function () {
                    if ((document.activeElement == j.$selection[0]) || (h.contains(j.$selection[0], document.activeElement))) {
                        return
                    }
                    j.trigger("blur", i)
                }, 1)
            };
            f.prototype._attachCloseHandler = function (i) {
                var j = this;
                h(document.body).on("mousedown.select2." + i.id, function (n) {
                    var k = h(n.target);
                    var l = k.closest(".select2");
                    var m = h(".select2.select2-container--open");
                    m.each(function () {
                        var p = h(this);
                        if (this == l[0]) {
                            return
                        }
                        var o = p.data("element");
                        o.select2("close")
                    })
                })
            };
            f.prototype._detachCloseHandler = function (i) {
                h(document.body).off("mousedown.select2." + i.id)
            };
            f.prototype.position = function (i, k) {
                var j = k.find(".selection");
                j.append(i)
            };
            f.prototype.destroy = function () {
                this._detachCloseHandler(this.container)
            };
            f.prototype.update = function (i) {
                throw new Error("The `update` method must be defined in child classes.")
            };
            return f
        });
        d.define("select2/selection/single", ["jquery", "./base", "../utils", "../keys"], function (h, f, g, e) {
            function i() {
                i.__super__.constructor.apply(this, arguments)
            }

            g.Extend(i, f);
            i.prototype.render = function () {
                var j = i.__super__.render.call(this);
                j.addClass("select2-selection--single");
                j.html('<span class="select2-selection__rendered"></span><span class="select2-selection__arrow" role="presentation"><b role="presentation"></b></span>');
                return j
            };
            i.prototype.bind = function (j, l) {
                var k = this;
                i.__super__.bind.apply(this, arguments);
                var m = j.id + "-container";
                this.$selection.find(".select2-selection__rendered").attr("id", m);
                this.$selection.attr("aria-labelledby", m);
                this.$selection.on("mousedown", function (n) {
                    if (n.which !== 1) {
                        return
                    }
                    k.trigger("toggle", {originalEvent: n})
                });
                this.$selection.on("focus", function (n) {
                });
                this.$selection.on("blur", function (n) {
                });
                j.on("focus", function (n) {
                    if (!j.isOpen()) {
                        k.$selection.focus()
                    }
                });
                j.on("selection:update", function (n) {
                    k.update(n.data)
                })
            };
            i.prototype.clear = function () {
                this.$selection.find(".select2-selection__rendered").empty()
            };
            i.prototype.display = function (m, k) {
                var l = this.options.get("templateSelection");
                var j = this.options.get("escapeMarkup");
                return j(l(m, k))
            };
            i.prototype.selectionContainer = function () {
                return h("<span></span>")
            };
            i.prototype.update = function (l) {
                if (l.length === 0) {
                    this.clear();
                    return
                }
                var j = l[0];
                var m = this.$selection.find(".select2-selection__rendered");
                var k = this.display(j, m);
                m.empty().append(k);
                m.prop("title", j.title || j.text)
            };
            return i
        });
        d.define("select2/selection/multiple", ["jquery", "./base", "../utils"], function (h, e, g) {
            function f(i, j) {
                f.__super__.constructor.apply(this, arguments)
            }

            g.Extend(f, e);
            f.prototype.render = function () {
                var i = f.__super__.render.call(this);
                i.addClass("select2-selection--multiple");
                i.html('<ul class="select2-selection__rendered"></ul>');
                return i
            };
            f.prototype.bind = function (i, k) {
                var j = this;
                f.__super__.bind.apply(this, arguments);
                this.$selection.on("click", function (l) {
                    j.trigger("toggle", {originalEvent: l})
                });
                this.$selection.on("click", ".select2-selection__choice__remove", function (m) {
                    if (j.options.get("disabled")) {
                        return
                    }
                    var n = h(this);
                    var l = n.parent();
                    var o = l.data("data");
                    j.trigger("unselect", {originalEvent: m, data: o})
                })
            };
            f.prototype.clear = function () {
                this.$selection.find(".select2-selection__rendered").empty()
            };
            f.prototype.display = function (l, j) {
                var k = this.options.get("templateSelection");
                var i = this.options.get("escapeMarkup");
                return i(k(l, j))
            };
            f.prototype.selectionContainer = function () {
                var i = h('<li class="select2-selection__choice"><span class="select2-selection__choice__remove" role="presentation">&times;</span></li>');
                return i
            };
            f.prototype.update = function (m) {
                this.clear();
                if (m.length === 0) {
                    return
                }
                var j = [];
                for (var o = 0; o < m.length; o++) {
                    var k = m[o];
                    var i = this.selectionContainer();
                    var l = this.display(k, i);
                    i.append(l);
                    i.prop("title", k.title || k.text);
                    i.data("data", k);
                    j.push(i)
                }
                var n = this.$selection.find(".select2-selection__rendered");
                g.appendMany(n, j)
            };
            return f
        });
        d.define("select2/selection/placeholder", ["../utils"], function (f) {
            function e(i, g, h) {
                this.placeholder = this.normalizePlaceholder(h.get("placeholder"));
                i.call(this, g, h)
            }

            e.prototype.normalizePlaceholder = function (g, h) {
                if (typeof h === "string") {
                    h = {id: "", text: h}
                }
                return h
            };
            e.prototype.createPlaceholder = function (h, i) {
                var g = this.selectionContainer();
                g.html(this.display(i));
                g.addClass("select2-selection__placeholder").removeClass("select2-selection__choice");
                return g
            };
            e.prototype.update = function (k, j) {
                var h = (j.length == 1 && j[0].id != this.placeholder.id);
                var i = j.length > 1;
                if (i || h) {
                    return k.call(this, j)
                }
                this.clear();
                var g = this.createPlaceholder(this.placeholder);
                this.$selection.find(".select2-selection__rendered").append(g)
            };
            return e
        });
        d.define("select2/selection/allowClear", ["jquery", "../keys"], function (f, e) {
            function g() {
            }

            g.prototype.bind = function (j, h, k) {
                var i = this;
                j.call(this, h, k);
                if (this.placeholder == null) {
                    if (this.options.get("debug") && window.console && console.error) {
                        console.error("Select2: The `allowClear` option should be used in combination with the `placeholder` option.")
                    }
                }
                this.$selection.on("mousedown", ".select2-selection__clear", function (l) {
                    i._handleClear(l)
                });
                h.on("keypress", function (l) {
                    i._handleKeyboardClear(l, h)
                })
            };
            g.prototype._handleClear = function (i, h) {
                if (this.options.get("disabled")) {
                    return
                }
                var l = this.$selection.find(".select2-selection__clear");
                if (l.length === 0) {
                    return
                }
                h.stopPropagation();
                var k = l.data("data");
                for (var m = 0; m < k.length; m++) {
                    var j = {data: k[m]};
                    this.trigger("unselect", j);
                    if (j.prevented) {
                        return
                    }
                }
                this.$element.val(this.placeholder.id).trigger("change");
                this.trigger("toggle", {})
            };
            g.prototype._handleKeyboardClear = function (j, i, h) {
                if (h.isOpen()) {
                    return
                }
                if (i.which == e.DELETE || i.which == e.BACKSPACE) {
                    this._handleClear(i)
                }
            };
            g.prototype.update = function (j, i) {
                j.call(this, i);
                if (this.$selection.find(".select2-selection__placeholder").length > 0 || i.length === 0) {
                    return
                }
                var h = f('<span class="select2-selection__clear">&times;</span>');
                h.data("data", i);
                this.$selection.find(".select2-selection__rendered").prepend(h)
            };
            return g
        });
        d.define("select2/selection/search", ["jquery", "../utils", "../keys"], function (h, g, e) {
            function f(k, i, j) {
                k.call(this, i, j)
            }

            f.prototype.render = function (j) {
                var i = h('<li class="select2-search select2-search--inline"><input class="select2-search__field" type="search" tabindex="-1" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" role="textbox" aria-autocomplete="list" /></li>');
                this.$searchContainer = i;
                this.$search = i.find("input");
                var k = j.call(this);
                this._transferTabIndex();
                return k
            };
            f.prototype.bind = function (m, j, n) {
                var k = this;
                m.call(this, j, n);
                j.on("open", function () {
                    k.$search.trigger("focus")
                });
                j.on("close", function () {
                    k.$search.val("");
                    k.$search.removeAttr("aria-activedescendant");
                    k.$search.trigger("focus")
                });
                j.on("enable", function () {
                    k.$search.prop("disabled", false);
                    k._transferTabIndex()
                });
                j.on("disable", function () {
                    k.$search.prop("disabled", true)
                });
                j.on("focus", function (o) {
                    k.$search.trigger("focus")
                });
                j.on("results:focus", function (o) {
                    k.$search.attr("aria-activedescendant", o.id)
                });
                this.$selection.on("focusin", ".select2-search--inline", function (o) {
                    k.trigger("focus", o)
                });
                this.$selection.on("focusout", ".select2-search--inline", function (o) {
                    k._handleBlur(o)
                });
                this.$selection.on("keydown", ".select2-search--inline", function (o) {
                    o.stopPropagation();
                    k.trigger("keypress", o);
                    k._keyUpPrevented = o.isDefaultPrevented();
                    var q = o.which;
                    if (q === e.BACKSPACE && k.$search.val() === "") {
                        var p = k.$searchContainer.prev(".select2-selection__choice");
                        if (p.length > 0) {
                            var r = p.data("data");
                            k.searchRemoveChoice(r);
                            o.preventDefault()
                        }
                    }
                });
                var l = document.documentMode;
                var i = l && l <= 11;
                this.$selection.on("input.searchcheck", ".select2-search--inline", function (o) {
                    if (i) {
                        k.$selection.off("input.search input.searchcheck");
                        return
                    }
                    k.$selection.off("keyup.search")
                });
                this.$selection.on("keyup.search input.search", ".select2-search--inline", function (o) {
                    if (i && o.type === "input") {
                        k.$selection.off("input.search input.searchcheck");
                        return
                    }
                    var p = o.which;
                    if (p == e.SHIFT || p == e.CTRL || p == e.ALT) {
                        return
                    }
                    if (p == e.TAB) {
                        return
                    }
                    k.handleSearch(o)
                })
            };
            f.prototype._transferTabIndex = function (i) {
                this.$search.attr("tabindex", this.$selection.attr("tabindex"));
                this.$selection.attr("tabindex", "-1")
            };
            f.prototype.createPlaceholder = function (i, j) {
                this.$search.attr("placeholder", j.text)
            };
            f.prototype.update = function (k, j) {
                var i = this.$search[0] == document.activeElement;
                this.$search.attr("placeholder", "");
                k.call(this, j);
                this.$selection.find(".select2-selection__rendered").append(this.$searchContainer);
                this.resizeSearch();
                if (i) {
                    this.$search.focus()
                }
            };
            f.prototype.handleSearch = function () {
                this.resizeSearch();
                if (!this._keyUpPrevented) {
                    var i = this.$search.val();
                    this.trigger("query", {term: i})
                }
                this._keyUpPrevented = false
            };
            f.prototype.searchRemoveChoice = function (j, i) {
                this.trigger("unselect", {data: i});
                this.$search.val(i.text);
                this.handleSearch()
            };
            f.prototype.resizeSearch = function () {
                this.$search.css("width", "25px");
                var i = "";
                if (this.$search.attr("placeholder") !== "") {
                    i = this.$selection.find(".select2-selection__rendered").innerWidth()
                } else {
                    var j = this.$search.val().length + 1;
                    i = (j * 0.75) + "em"
                }
                this.$search.css("width", i)
            };
            return f
        });
        d.define("select2/selection/eventRelay", ["jquery"], function (e) {
            function f() {
            }

            f.prototype.bind = function (k, g, l) {
                var h = this;
                var i = ["open", "opening", "close", "closing", "select", "selecting", "unselect", "unselecting"];
                var j = ["opening", "closing", "selecting", "unselecting"];
                k.call(this, g, l);
                g.on("*", function (n, o) {
                    if (e.inArray(n, i) === -1) {
                        return
                    }
                    o = o || {};
                    var m = e.Event("select2:" + n, {params: o});
                    h.$element.trigger(m);
                    if (e.inArray(n, j) === -1) {
                        return
                    }
                    o.prevented = m.isDefaultPrevented()
                })
            };
            return f
        });
        d.define("select2/translation", ["jquery", "require"], function (g, f) {
            function e(h) {
                this.dict = h || {}
            }

            e.prototype.all = function () {
                return this.dict
            };
            e.prototype.get = function (h) {
                return this.dict[h]
            };
            e.prototype.extend = function (h) {
                this.dict = g.extend({}, h.all(), this.dict)
            };
            e._cache = {};
            e.loadPath = function (i) {
                if (!(i in e._cache)) {
                    var h = f(i);
                    e._cache[i] = h
                }
                return new e(e._cache[i])
            };
            return e
        });
        d.define("select2/diacritics", [], function () {
            var e = {
                "\u24B6": "A",
                "\uFF21": "A",
                "\u00C0": "A",
                "\u00C1": "A",
                "\u00C2": "A",
                "\u1EA6": "A",
                "\u1EA4": "A",
                "\u1EAA": "A",
                "\u1EA8": "A",
                "\u00C3": "A",
                "\u0100": "A",
                "\u0102": "A",
                "\u1EB0": "A",
                "\u1EAE": "A",
                "\u1EB4": "A",
                "\u1EB2": "A",
                "\u0226": "A",
                "\u01E0": "A",
                "\u00C4": "A",
                "\u01DE": "A",
                "\u1EA2": "A",
                "\u00C5": "A",
                "\u01FA": "A",
                "\u01CD": "A",
                "\u0200": "A",
                "\u0202": "A",
                "\u1EA0": "A",
                "\u1EAC": "A",
                "\u1EB6": "A",
                "\u1E00": "A",
                "\u0104": "A",
                "\u023A": "A",
                "\u2C6F": "A",
                "\uA732": "AA",
                "\u00C6": "AE",
                "\u01FC": "AE",
                "\u01E2": "AE",
                "\uA734": "AO",
                "\uA736": "AU",
                "\uA738": "AV",
                "\uA73A": "AV",
                "\uA73C": "AY",
                "\u24B7": "B",
                "\uFF22": "B",
                "\u1E02": "B",
                "\u1E04": "B",
                "\u1E06": "B",
                "\u0243": "B",
                "\u0182": "B",
                "\u0181": "B",
                "\u24B8": "C",
                "\uFF23": "C",
                "\u0106": "C",
                "\u0108": "C",
                "\u010A": "C",
                "\u010C": "C",
                "\u00C7": "C",
                "\u1E08": "C",
                "\u0187": "C",
                "\u023B": "C",
                "\uA73E": "C",
                "\u24B9": "D",
                "\uFF24": "D",
                "\u1E0A": "D",
                "\u010E": "D",
                "\u1E0C": "D",
                "\u1E10": "D",
                "\u1E12": "D",
                "\u1E0E": "D",
                "\u0110": "D",
                "\u018B": "D",
                "\u018A": "D",
                "\u0189": "D",
                "\uA779": "D",
                "\u01F1": "DZ",
                "\u01C4": "DZ",
                "\u01F2": "Dz",
                "\u01C5": "Dz",
                "\u24BA": "E",
                "\uFF25": "E",
                "\u00C8": "E",
                "\u00C9": "E",
                "\u00CA": "E",
                "\u1EC0": "E",
                "\u1EBE": "E",
                "\u1EC4": "E",
                "\u1EC2": "E",
                "\u1EBC": "E",
                "\u0112": "E",
                "\u1E14": "E",
                "\u1E16": "E",
                "\u0114": "E",
                "\u0116": "E",
                "\u00CB": "E",
                "\u1EBA": "E",
                "\u011A": "E",
                "\u0204": "E",
                "\u0206": "E",
                "\u1EB8": "E",
                "\u1EC6": "E",
                "\u0228": "E",
                "\u1E1C": "E",
                "\u0118": "E",
                "\u1E18": "E",
                "\u1E1A": "E",
                "\u0190": "E",
                "\u018E": "E",
                "\u24BB": "F",
                "\uFF26": "F",
                "\u1E1E": "F",
                "\u0191": "F",
                "\uA77B": "F",
                "\u24BC": "G",
                "\uFF27": "G",
                "\u01F4": "G",
                "\u011C": "G",
                "\u1E20": "G",
                "\u011E": "G",
                "\u0120": "G",
                "\u01E6": "G",
                "\u0122": "G",
                "\u01E4": "G",
                "\u0193": "G",
                "\uA7A0": "G",
                "\uA77D": "G",
                "\uA77E": "G",
                "\u24BD": "H",
                "\uFF28": "H",
                "\u0124": "H",
                "\u1E22": "H",
                "\u1E26": "H",
                "\u021E": "H",
                "\u1E24": "H",
                "\u1E28": "H",
                "\u1E2A": "H",
                "\u0126": "H",
                "\u2C67": "H",
                "\u2C75": "H",
                "\uA78D": "H",
                "\u24BE": "I",
                "\uFF29": "I",
                "\u00CC": "I",
                "\u00CD": "I",
                "\u00CE": "I",
                "\u0128": "I",
                "\u012A": "I",
                "\u012C": "I",
                "\u0130": "I",
                "\u00CF": "I",
                "\u1E2E": "I",
                "\u1EC8": "I",
                "\u01CF": "I",
                "\u0208": "I",
                "\u020A": "I",
                "\u1ECA": "I",
                "\u012E": "I",
                "\u1E2C": "I",
                "\u0197": "I",
                "\u24BF": "J",
                "\uFF2A": "J",
                "\u0134": "J",
                "\u0248": "J",
                "\u24C0": "K",
                "\uFF2B": "K",
                "\u1E30": "K",
                "\u01E8": "K",
                "\u1E32": "K",
                "\u0136": "K",
                "\u1E34": "K",
                "\u0198": "K",
                "\u2C69": "K",
                "\uA740": "K",
                "\uA742": "K",
                "\uA744": "K",
                "\uA7A2": "K",
                "\u24C1": "L",
                "\uFF2C": "L",
                "\u013F": "L",
                "\u0139": "L",
                "\u013D": "L",
                "\u1E36": "L",
                "\u1E38": "L",
                "\u013B": "L",
                "\u1E3C": "L",
                "\u1E3A": "L",
                "\u0141": "L",
                "\u023D": "L",
                "\u2C62": "L",
                "\u2C60": "L",
                "\uA748": "L",
                "\uA746": "L",
                "\uA780": "L",
                "\u01C7": "LJ",
                "\u01C8": "Lj",
                "\u24C2": "M",
                "\uFF2D": "M",
                "\u1E3E": "M",
                "\u1E40": "M",
                "\u1E42": "M",
                "\u2C6E": "M",
                "\u019C": "M",
                "\u24C3": "N",
                "\uFF2E": "N",
                "\u01F8": "N",
                "\u0143": "N",
                "\u00D1": "N",
                "\u1E44": "N",
                "\u0147": "N",
                "\u1E46": "N",
                "\u0145": "N",
                "\u1E4A": "N",
                "\u1E48": "N",
                "\u0220": "N",
                "\u019D": "N",
                "\uA790": "N",
                "\uA7A4": "N",
                "\u01CA": "NJ",
                "\u01CB": "Nj",
                "\u24C4": "O",
                "\uFF2F": "O",
                "\u00D2": "O",
                "\u00D3": "O",
                "\u00D4": "O",
                "\u1ED2": "O",
                "\u1ED0": "O",
                "\u1ED6": "O",
                "\u1ED4": "O",
                "\u00D5": "O",
                "\u1E4C": "O",
                "\u022C": "O",
                "\u1E4E": "O",
                "\u014C": "O",
                "\u1E50": "O",
                "\u1E52": "O",
                "\u014E": "O",
                "\u022E": "O",
                "\u0230": "O",
                "\u00D6": "O",
                "\u022A": "O",
                "\u1ECE": "O",
                "\u0150": "O",
                "\u01D1": "O",
                "\u020C": "O",
                "\u020E": "O",
                "\u01A0": "O",
                "\u1EDC": "O",
                "\u1EDA": "O",
                "\u1EE0": "O",
                "\u1EDE": "O",
                "\u1EE2": "O",
                "\u1ECC": "O",
                "\u1ED8": "O",
                "\u01EA": "O",
                "\u01EC": "O",
                "\u00D8": "O",
                "\u01FE": "O",
                "\u0186": "O",
                "\u019F": "O",
                "\uA74A": "O",
                "\uA74C": "O",
                "\u01A2": "OI",
                "\uA74E": "OO",
                "\u0222": "OU",
                "\u24C5": "P",
                "\uFF30": "P",
                "\u1E54": "P",
                "\u1E56": "P",
                "\u01A4": "P",
                "\u2C63": "P",
                "\uA750": "P",
                "\uA752": "P",
                "\uA754": "P",
                "\u24C6": "Q",
                "\uFF31": "Q",
                "\uA756": "Q",
                "\uA758": "Q",
                "\u024A": "Q",
                "\u24C7": "R",
                "\uFF32": "R",
                "\u0154": "R",
                "\u1E58": "R",
                "\u0158": "R",
                "\u0210": "R",
                "\u0212": "R",
                "\u1E5A": "R",
                "\u1E5C": "R",
                "\u0156": "R",
                "\u1E5E": "R",
                "\u024C": "R",
                "\u2C64": "R",
                "\uA75A": "R",
                "\uA7A6": "R",
                "\uA782": "R",
                "\u24C8": "S",
                "\uFF33": "S",
                "\u1E9E": "S",
                "\u015A": "S",
                "\u1E64": "S",
                "\u015C": "S",
                "\u1E60": "S",
                "\u0160": "S",
                "\u1E66": "S",
                "\u1E62": "S",
                "\u1E68": "S",
                "\u0218": "S",
                "\u015E": "S",
                "\u2C7E": "S",
                "\uA7A8": "S",
                "\uA784": "S",
                "\u24C9": "T",
                "\uFF34": "T",
                "\u1E6A": "T",
                "\u0164": "T",
                "\u1E6C": "T",
                "\u021A": "T",
                "\u0162": "T",
                "\u1E70": "T",
                "\u1E6E": "T",
                "\u0166": "T",
                "\u01AC": "T",
                "\u01AE": "T",
                "\u023E": "T",
                "\uA786": "T",
                "\uA728": "TZ",
                "\u24CA": "U",
                "\uFF35": "U",
                "\u00D9": "U",
                "\u00DA": "U",
                "\u00DB": "U",
                "\u0168": "U",
                "\u1E78": "U",
                "\u016A": "U",
                "\u1E7A": "U",
                "\u016C": "U",
                "\u00DC": "U",
                "\u01DB": "U",
                "\u01D7": "U",
                "\u01D5": "U",
                "\u01D9": "U",
                "\u1EE6": "U",
                "\u016E": "U",
                "\u0170": "U",
                "\u01D3": "U",
                "\u0214": "U",
                "\u0216": "U",
                "\u01AF": "U",
                "\u1EEA": "U",
                "\u1EE8": "U",
                "\u1EEE": "U",
                "\u1EEC": "U",
                "\u1EF0": "U",
                "\u1EE4": "U",
                "\u1E72": "U",
                "\u0172": "U",
                "\u1E76": "U",
                "\u1E74": "U",
                "\u0244": "U",
                "\u24CB": "V",
                "\uFF36": "V",
                "\u1E7C": "V",
                "\u1E7E": "V",
                "\u01B2": "V",
                "\uA75E": "V",
                "\u0245": "V",
                "\uA760": "VY",
                "\u24CC": "W",
                "\uFF37": "W",
                "\u1E80": "W",
                "\u1E82": "W",
                "\u0174": "W",
                "\u1E86": "W",
                "\u1E84": "W",
                "\u1E88": "W",
                "\u2C72": "W",
                "\u24CD": "X",
                "\uFF38": "X",
                "\u1E8A": "X",
                "\u1E8C": "X",
                "\u24CE": "Y",
                "\uFF39": "Y",
                "\u1EF2": "Y",
                "\u00DD": "Y",
                "\u0176": "Y",
                "\u1EF8": "Y",
                "\u0232": "Y",
                "\u1E8E": "Y",
                "\u0178": "Y",
                "\u1EF6": "Y",
                "\u1EF4": "Y",
                "\u01B3": "Y",
                "\u024E": "Y",
                "\u1EFE": "Y",
                "\u24CF": "Z",
                "\uFF3A": "Z",
                "\u0179": "Z",
                "\u1E90": "Z",
                "\u017B": "Z",
                "\u017D": "Z",
                "\u1E92": "Z",
                "\u1E94": "Z",
                "\u01B5": "Z",
                "\u0224": "Z",
                "\u2C7F": "Z",
                "\u2C6B": "Z",
                "\uA762": "Z",
                "\u24D0": "a",
                "\uFF41": "a",
                "\u1E9A": "a",
                "\u00E0": "a",
                "\u00E1": "a",
                "\u00E2": "a",
                "\u1EA7": "a",
                "\u1EA5": "a",
                "\u1EAB": "a",
                "\u1EA9": "a",
                "\u00E3": "a",
                "\u0101": "a",
                "\u0103": "a",
                "\u1EB1": "a",
                "\u1EAF": "a",
                "\u1EB5": "a",
                "\u1EB3": "a",
                "\u0227": "a",
                "\u01E1": "a",
                "\u00E4": "a",
                "\u01DF": "a",
                "\u1EA3": "a",
                "\u00E5": "a",
                "\u01FB": "a",
                "\u01CE": "a",
                "\u0201": "a",
                "\u0203": "a",
                "\u1EA1": "a",
                "\u1EAD": "a",
                "\u1EB7": "a",
                "\u1E01": "a",
                "\u0105": "a",
                "\u2C65": "a",
                "\u0250": "a",
                "\uA733": "aa",
                "\u00E6": "ae",
                "\u01FD": "ae",
                "\u01E3": "ae",
                "\uA735": "ao",
                "\uA737": "au",
                "\uA739": "av",
                "\uA73B": "av",
                "\uA73D": "ay",
                "\u24D1": "b",
                "\uFF42": "b",
                "\u1E03": "b",
                "\u1E05": "b",
                "\u1E07": "b",
                "\u0180": "b",
                "\u0183": "b",
                "\u0253": "b",
                "\u24D2": "c",
                "\uFF43": "c",
                "\u0107": "c",
                "\u0109": "c",
                "\u010B": "c",
                "\u010D": "c",
                "\u00E7": "c",
                "\u1E09": "c",
                "\u0188": "c",
                "\u023C": "c",
                "\uA73F": "c",
                "\u2184": "c",
                "\u24D3": "d",
                "\uFF44": "d",
                "\u1E0B": "d",
                "\u010F": "d",
                "\u1E0D": "d",
                "\u1E11": "d",
                "\u1E13": "d",
                "\u1E0F": "d",
                "\u0111": "d",
                "\u018C": "d",
                "\u0256": "d",
                "\u0257": "d",
                "\uA77A": "d",
                "\u01F3": "dz",
                "\u01C6": "dz",
                "\u24D4": "e",
                "\uFF45": "e",
                "\u00E8": "e",
                "\u00E9": "e",
                "\u00EA": "e",
                "\u1EC1": "e",
                "\u1EBF": "e",
                "\u1EC5": "e",
                "\u1EC3": "e",
                "\u1EBD": "e",
                "\u0113": "e",
                "\u1E15": "e",
                "\u1E17": "e",
                "\u0115": "e",
                "\u0117": "e",
                "\u00EB": "e",
                "\u1EBB": "e",
                "\u011B": "e",
                "\u0205": "e",
                "\u0207": "e",
                "\u1EB9": "e",
                "\u1EC7": "e",
                "\u0229": "e",
                "\u1E1D": "e",
                "\u0119": "e",
                "\u1E19": "e",
                "\u1E1B": "e",
                "\u0247": "e",
                "\u025B": "e",
                "\u01DD": "e",
                "\u24D5": "f",
                "\uFF46": "f",
                "\u1E1F": "f",
                "\u0192": "f",
                "\uA77C": "f",
                "\u24D6": "g",
                "\uFF47": "g",
                "\u01F5": "g",
                "\u011D": "g",
                "\u1E21": "g",
                "\u011F": "g",
                "\u0121": "g",
                "\u01E7": "g",
                "\u0123": "g",
                "\u01E5": "g",
                "\u0260": "g",
                "\uA7A1": "g",
                "\u1D79": "g",
                "\uA77F": "g",
                "\u24D7": "h",
                "\uFF48": "h",
                "\u0125": "h",
                "\u1E23": "h",
                "\u1E27": "h",
                "\u021F": "h",
                "\u1E25": "h",
                "\u1E29": "h",
                "\u1E2B": "h",
                "\u1E96": "h",
                "\u0127": "h",
                "\u2C68": "h",
                "\u2C76": "h",
                "\u0265": "h",
                "\u0195": "hv",
                "\u24D8": "i",
                "\uFF49": "i",
                "\u00EC": "i",
                "\u00ED": "i",
                "\u00EE": "i",
                "\u0129": "i",
                "\u012B": "i",
                "\u012D": "i",
                "\u00EF": "i",
                "\u1E2F": "i",
                "\u1EC9": "i",
                "\u01D0": "i",
                "\u0209": "i",
                "\u020B": "i",
                "\u1ECB": "i",
                "\u012F": "i",
                "\u1E2D": "i",
                "\u0268": "i",
                "\u0131": "i",
                "\u24D9": "j",
                "\uFF4A": "j",
                "\u0135": "j",
                "\u01F0": "j",
                "\u0249": "j",
                "\u24DA": "k",
                "\uFF4B": "k",
                "\u1E31": "k",
                "\u01E9": "k",
                "\u1E33": "k",
                "\u0137": "k",
                "\u1E35": "k",
                "\u0199": "k",
                "\u2C6A": "k",
                "\uA741": "k",
                "\uA743": "k",
                "\uA745": "k",
                "\uA7A3": "k",
                "\u24DB": "l",
                "\uFF4C": "l",
                "\u0140": "l",
                "\u013A": "l",
                "\u013E": "l",
                "\u1E37": "l",
                "\u1E39": "l",
                "\u013C": "l",
                "\u1E3D": "l",
                "\u1E3B": "l",
                "\u017F": "l",
                "\u0142": "l",
                "\u019A": "l",
                "\u026B": "l",
                "\u2C61": "l",
                "\uA749": "l",
                "\uA781": "l",
                "\uA747": "l",
                "\u01C9": "lj",
                "\u24DC": "m",
                "\uFF4D": "m",
                "\u1E3F": "m",
                "\u1E41": "m",
                "\u1E43": "m",
                "\u0271": "m",
                "\u026F": "m",
                "\u24DD": "n",
                "\uFF4E": "n",
                "\u01F9": "n",
                "\u0144": "n",
                "\u00F1": "n",
                "\u1E45": "n",
                "\u0148": "n",
                "\u1E47": "n",
                "\u0146": "n",
                "\u1E4B": "n",
                "\u1E49": "n",
                "\u019E": "n",
                "\u0272": "n",
                "\u0149": "n",
                "\uA791": "n",
                "\uA7A5": "n",
                "\u01CC": "nj",
                "\u24DE": "o",
                "\uFF4F": "o",
                "\u00F2": "o",
                "\u00F3": "o",
                "\u00F4": "o",
                "\u1ED3": "o",
                "\u1ED1": "o",
                "\u1ED7": "o",
                "\u1ED5": "o",
                "\u00F5": "o",
                "\u1E4D": "o",
                "\u022D": "o",
                "\u1E4F": "o",
                "\u014D": "o",
                "\u1E51": "o",
                "\u1E53": "o",
                "\u014F": "o",
                "\u022F": "o",
                "\u0231": "o",
                "\u00F6": "o",
                "\u022B": "o",
                "\u1ECF": "o",
                "\u0151": "o",
                "\u01D2": "o",
                "\u020D": "o",
                "\u020F": "o",
                "\u01A1": "o",
                "\u1EDD": "o",
                "\u1EDB": "o",
                "\u1EE1": "o",
                "\u1EDF": "o",
                "\u1EE3": "o",
                "\u1ECD": "o",
                "\u1ED9": "o",
                "\u01EB": "o",
                "\u01ED": "o",
                "\u00F8": "o",
                "\u01FF": "o",
                "\u0254": "o",
                "\uA74B": "o",
                "\uA74D": "o",
                "\u0275": "o",
                "\u01A3": "oi",
                "\u0223": "ou",
                "\uA74F": "oo",
                "\u24DF": "p",
                "\uFF50": "p",
                "\u1E55": "p",
                "\u1E57": "p",
                "\u01A5": "p",
                "\u1D7D": "p",
                "\uA751": "p",
                "\uA753": "p",
                "\uA755": "p",
                "\u24E0": "q",
                "\uFF51": "q",
                "\u024B": "q",
                "\uA757": "q",
                "\uA759": "q",
                "\u24E1": "r",
                "\uFF52": "r",
                "\u0155": "r",
                "\u1E59": "r",
                "\u0159": "r",
                "\u0211": "r",
                "\u0213": "r",
                "\u1E5B": "r",
                "\u1E5D": "r",
                "\u0157": "r",
                "\u1E5F": "r",
                "\u024D": "r",
                "\u027D": "r",
                "\uA75B": "r",
                "\uA7A7": "r",
                "\uA783": "r",
                "\u24E2": "s",
                "\uFF53": "s",
                "\u00DF": "s",
                "\u015B": "s",
                "\u1E65": "s",
                "\u015D": "s",
                "\u1E61": "s",
                "\u0161": "s",
                "\u1E67": "s",
                "\u1E63": "s",
                "\u1E69": "s",
                "\u0219": "s",
                "\u015F": "s",
                "\u023F": "s",
                "\uA7A9": "s",
                "\uA785": "s",
                "\u1E9B": "s",
                "\u24E3": "t",
                "\uFF54": "t",
                "\u1E6B": "t",
                "\u1E97": "t",
                "\u0165": "t",
                "\u1E6D": "t",
                "\u021B": "t",
                "\u0163": "t",
                "\u1E71": "t",
                "\u1E6F": "t",
                "\u0167": "t",
                "\u01AD": "t",
                "\u0288": "t",
                "\u2C66": "t",
                "\uA787": "t",
                "\uA729": "tz",
                "\u24E4": "u",
                "\uFF55": "u",
                "\u00F9": "u",
                "\u00FA": "u",
                "\u00FB": "u",
                "\u0169": "u",
                "\u1E79": "u",
                "\u016B": "u",
                "\u1E7B": "u",
                "\u016D": "u",
                "\u00FC": "u",
                "\u01DC": "u",
                "\u01D8": "u",
                "\u01D6": "u",
                "\u01DA": "u",
                "\u1EE7": "u",
                "\u016F": "u",
                "\u0171": "u",
                "\u01D4": "u",
                "\u0215": "u",
                "\u0217": "u",
                "\u01B0": "u",
                "\u1EEB": "u",
                "\u1EE9": "u",
                "\u1EEF": "u",
                "\u1EED": "u",
                "\u1EF1": "u",
                "\u1EE5": "u",
                "\u1E73": "u",
                "\u0173": "u",
                "\u1E77": "u",
                "\u1E75": "u",
                "\u0289": "u",
                "\u24E5": "v",
                "\uFF56": "v",
                "\u1E7D": "v",
                "\u1E7F": "v",
                "\u028B": "v",
                "\uA75F": "v",
                "\u028C": "v",
                "\uA761": "vy",
                "\u24E6": "w",
                "\uFF57": "w",
                "\u1E81": "w",
                "\u1E83": "w",
                "\u0175": "w",
                "\u1E87": "w",
                "\u1E85": "w",
                "\u1E98": "w",
                "\u1E89": "w",
                "\u2C73": "w",
                "\u24E7": "x",
                "\uFF58": "x",
                "\u1E8B": "x",
                "\u1E8D": "x",
                "\u24E8": "y",
                "\uFF59": "y",
                "\u1EF3": "y",
                "\u00FD": "y",
                "\u0177": "y",
                "\u1EF9": "y",
                "\u0233": "y",
                "\u1E8F": "y",
                "\u00FF": "y",
                "\u1EF7": "y",
                "\u1E99": "y",
                "\u1EF5": "y",
                "\u01B4": "y",
                "\u024F": "y",
                "\u1EFF": "y",
                "\u24E9": "z",
                "\uFF5A": "z",
                "\u017A": "z",
                "\u1E91": "z",
                "\u017C": "z",
                "\u017E": "z",
                "\u1E93": "z",
                "\u1E95": "z",
                "\u01B6": "z",
                "\u0225": "z",
                "\u0240": "z",
                "\u2C6C": "z",
                "\uA763": "z",
                "\u0386": "\u0391",
                "\u0388": "\u0395",
                "\u0389": "\u0397",
                "\u038A": "\u0399",
                "\u03AA": "\u0399",
                "\u038C": "\u039F",
                "\u038E": "\u03A5",
                "\u03AB": "\u03A5",
                "\u038F": "\u03A9",
                "\u03AC": "\u03B1",
                "\u03AD": "\u03B5",
                "\u03AE": "\u03B7",
                "\u03AF": "\u03B9",
                "\u03CA": "\u03B9",
                "\u0390": "\u03B9",
                "\u03CC": "\u03BF",
                "\u03CD": "\u03C5",
                "\u03CB": "\u03C5",
                "\u03B0": "\u03C5",
                "\u03C9": "\u03C9",
                "\u03C2": "\u03C3"
            };
            return e
        });
        d.define("select2/data/base", ["../utils"], function (f) {
            function e(g, h) {
                e.__super__.constructor.call(this)
            }

            f.Extend(e, f.Observable);
            e.prototype.current = function (g) {
                throw new Error("The `current` method must be defined in child classes.")
            };
            e.prototype.query = function (g, h) {
                throw new Error("The `query` method must be defined in child classes.")
            };
            e.prototype.bind = function (g, h) {
            };
            e.prototype.destroy = function () {
            };
            e.prototype.generateResultId = function (g, h) {
                var i = g.id + "-result-";
                i += f.generateChars(4);
                if (h.id != null) {
                    i += "-" + h.id.toString()
                } else {
                    i += "-" + f.generateChars(4)
                }
                return i
            };
            return e
        });
        d.define("select2/data/select", ["./base", "../utils", "jquery"], function (e, h, g) {
            function f(i, j) {
                this.$element = i;
                this.options = j;
                f.__super__.constructor.call(this)
            }

            h.Extend(f, e);
            f.prototype.current = function (k) {
                var j = [];
                var i = this;
                this.$element.find(":selected").each(function () {
                    var m = g(this);
                    var l = i.item(m);
                    j.push(l)
                });
                k(j)
            };
            f.prototype.select = function (j) {
                var i = this;
                j.selected = true;
                if (g(j.element).is("option")) {
                    j.element.selected = true;
                    this.$element.trigger("change");
                    return
                }
                if (this.$element.prop("multiple")) {
                    this.current(function (l) {
                        var n = [];
                        j = [j];
                        j.push.apply(j, l);
                        for (var m = 0; m < j.length; m++) {
                            var o = j[m].id;
                            if (g.inArray(o, n) === -1) {
                                n.push(o)
                            }
                        }
                        i.$element.val(n);
                        i.$element.trigger("change")
                    })
                } else {
                    var k = j.id;
                    this.$element.val(k);
                    this.$element.trigger("change")
                }
            };
            f.prototype.unselect = function (j) {
                var i = this;
                if (!this.$element.prop("multiple")) {
                    return
                }
                j.selected = false;
                if (g(j.element).is("option")) {
                    j.element.selected = false;
                    this.$element.trigger("change");
                    return
                }
                this.current(function (k) {
                    var m = [];
                    for (var l = 0; l < k.length; l++) {
                        var n = k[l].id;
                        if (n !== j.id && g.inArray(n, m) === -1) {
                            m.push(n)
                        }
                    }
                    i.$element.val(m);
                    i.$element.trigger("change")
                })
            };
            f.prototype.bind = function (i, k) {
                var j = this;
                this.container = i;
                i.on("select", function (l) {
                    j.select(l.data)
                });
                i.on("unselect", function (l) {
                    j.unselect(l.data)
                })
            };
            f.prototype.destroy = function () {
                this.$element.find("*").each(function () {
                    g.removeData(this, "data")
                })
            };
            f.prototype.query = function (l, m) {
                var k = [];
                var j = this;
                var i = this.$element.children();
                i.each(function () {
                    var p = g(this);
                    if (!p.is("option") && !p.is("optgroup")) {
                        return
                    }
                    var n = j.item(p);
                    var o = j.matches(l, n);
                    if (o !== null) {
                        k.push(o)
                    }
                });
                m({results: k})
            };
            f.prototype.addOptions = function (i) {
                h.appendMany(this.$element, i)
            };
            f.prototype.option = function (j) {
                var i;
                if (j.children) {
                    i = document.createElement("optgroup");
                    i.label = j.text
                } else {
                    i = document.createElement("option");
                    if (i.textContent !== undefined) {
                        i.textContent = j.text
                    } else {
                        i.innerText = j.text
                    }
                }
                if (j.id) {
                    i.value = j.id
                }
                if (j.disabled) {
                    i.disabled = true
                }
                if (j.selected) {
                    i.selected = true
                }
                if (j.title) {
                    i.title = j.title
                }
                var k = g(i);
                var l = this._normalizeItem(j);
                l.element = i;
                g.data(i, "data", l);
                return k
            };
            f.prototype.item = function (m) {
                var l = {};
                l = g.data(m[0], "data");
                if (l != null) {
                    return l
                }
                if (m.is("option")) {
                    l = {
                        id: m.val(),
                        text: m.text(),
                        disabled: m.prop("disabled"),
                        selected: m.prop("selected"),
                        title: m.prop("title")
                    }
                } else {
                    if (m.is("optgroup")) {
                        l = {text: m.prop("label"), children: [], title: m.prop("title")};
                        var i = m.children("option");
                        var j = [];
                        for (var o = 0; o < i.length; o++) {
                            var k = g(i[o]);
                            var n = this.item(k);
                            j.push(n)
                        }
                        l.children = j
                    }
                }
                l = this._normalizeItem(l);
                l.element = m[0];
                g.data(m[0], "data", l);
                return l
            };
            f.prototype._normalizeItem = function (i) {
                if (!g.isPlainObject(i)) {
                    i = {id: i, text: i}
                }
                i = g.extend({}, {text: ""}, i);
                var j = {selected: false, disabled: false};
                if (i.id != null) {
                    i.id = i.id.toString()
                }
                if (i.text != null) {
                    i.text = i.text.toString()
                }
                if (i._resultId == null && i.id && this.container != null) {
                    i._resultId = this.generateResultId(this.container, i)
                }
                return g.extend({}, j, i)
            };
            f.prototype.matches = function (k, i) {
                var j = this.options.get("matcher");
                return j(k, i)
            };
            return f
        });
        d.define("select2/data/array", ["./select", "../utils", "jquery"], function (e, g, f) {
            function h(i, j) {
                var k = j.get("data") || [];
                h.__super__.constructor.call(this, i, j);
                this.addOptions(this.convertToOptions(k))
            }

            g.Extend(h, e);
            h.prototype.select = function (i) {
                var j = this.$element.find("option").filter(function (k, l) {
                    return l.value == i.id.toString()
                });
                if (j.length === 0) {
                    j = this.option(i);
                    this.addOptions(j)
                }
                h.__super__.select.call(this, i)
            };
            h.prototype.convertToOptions = function (k) {
                var u = this;
                var n = this.$element.find("option");
                var j = n.map(function () {
                    return u.item(f(this)).id
                }).get();
                var m = [];

                function r(w) {
                    return function () {
                        return f(this).val() == w.id
                    }
                }

                for (var q = 0; q < k.length; q++) {
                    var t = this._normalizeItem(k[q]);
                    if (f.inArray(t.id, j) >= 0) {
                        var o = n.filter(r(t));
                        var p = this.item(o);
                        var v = f.extend(true, {}, t, p);
                        var l = this.option(v);
                        o.replaceWith(l);
                        continue
                    }
                    var i = this.option(t);
                    if (t.children) {
                        var s = this.convertToOptions(t.children);
                        g.appendMany(i, s)
                    }
                    m.push(i)
                }
                return m
            };
            return h
        });
        d.define("select2/data/ajax", ["./array", "../utils", "jquery"], function (h, g, f) {
            function e(i, j) {
                this.ajaxOptions = this._applyDefaults(j.get("ajax"));
                if (this.ajaxOptions.processResults != null) {
                    this.processResults = this.ajaxOptions.processResults
                }
                e.__super__.constructor.call(this, i, j)
            }

            g.Extend(e, h);
            e.prototype._applyDefaults = function (i) {
                var j = {
                    data: function (k) {
                        return f.extend({}, k, {q: k.term})
                    }, transport: function (n, m, l) {
                        var k = f.ajax(n);
                        k.then(m);
                        k.fail(l);
                        return k
                    }
                };
                return f.extend({}, j, i, true)
            };
            e.prototype.processResults = function (i) {
                return i
            };
            e.prototype.query = function (m, n) {
                var l = [];
                var i = this;
                if (this._request != null) {
                    if (f.isFunction(this._request.abort)) {
                        this._request.abort()
                    }
                    this._request = null
                }
                var j = f.extend({type: "GET"}, this.ajaxOptions);
                if (typeof j.url === "function") {
                    j.url = j.url.call(this.$element, m)
                }
                if (typeof j.data === "function") {
                    j.data = j.data.call(this.$element, m)
                }

                function k() {
                    var o = j.transport(j, function (q) {
                        var p = i.processResults(q, m);
                        if (i.options.get("debug") && window.console && console.error) {
                            if (!p || !p.results || !f.isArray(p.results)) {
                                console.error("Select2: The AJAX results did not return an array in the `results` key of the response.")
                            }
                        }
                        n(p)
                    }, function () {
                        if (o.status && o.status === "0") {
                            return
                        }
                        i.trigger("results:message", {message: "errorLoading"})
                    });
                    i._request = o
                }

                if (this.ajaxOptions.delay && m.term != null) {
                    if (this._queryTimeout) {
                        window.clearTimeout(this._queryTimeout)
                    }
                    this._queryTimeout = window.setTimeout(k, this.ajaxOptions.delay)
                } else {
                    k()
                }
            };
            return e
        });
        d.define("select2/data/tags", ["jquery"], function (f) {
            function e(h, k, n) {
                var o = n.get("tags");
                var i = n.get("createTag");
                if (i !== undefined) {
                    this.createTag = i
                }
                var j = n.get("insertTag");
                if (j !== undefined) {
                    this.insertTag = j
                }
                h.call(this, k, n);
                if (f.isArray(o)) {
                    for (var m = 0; m < o.length; m++) {
                        var p = o[m];
                        var l = this._normalizeItem(p);
                        var g = this.option(l);
                        this.$element.append(g)
                    }
                }
            }

            e.prototype.query = function (h, i, k) {
                var g = this;
                this._removeOldTags();
                if (i.term == null || i.page != null) {
                    h.call(this, i, k);
                    return
                }

                function j(p, m) {
                    var q = p.results;
                    for (var r = 0; r < q.length; r++) {
                        var s = q[r];
                        var n = (s.children != null && !j({results: s.children}, true));
                        var o = s.text === i.term;
                        if (o || n) {
                            if (m) {
                                return false
                            }
                            p.data = q;
                            k(p);
                            return
                        }
                    }
                    if (m) {
                        return true
                    }
                    var t = g.createTag(i);
                    if (t != null) {
                        var l = g.option(t);
                        l.attr("data-select2-tag", true);
                        g.addOptions([l]);
                        g.insertTag(q, t)
                    }
                    p.results = q;
                    k(p)
                }

                h.call(this, i, j)
            };
            e.prototype.createTag = function (h, i) {
                var g = f.trim(i.term);
                if (g === "") {
                    return null
                }
                return {id: g, text: g}
            };
            e.prototype.insertTag = function (h, i, g) {
                i.unshift(g)
            };
            e.prototype._removeOldTags = function (i) {
                var h = this._lastTag;
                var g = this.$element.find("option[data-select2-tag]");
                g.each(function () {
                    if (this.selected) {
                        return
                    }
                    f(this).remove()
                })
            };
            return e
        });
        d.define("select2/data/tokenizer", ["jquery"], function (f) {
            function e(j, g, h) {
                var i = h.get("tokenizer");
                if (i !== undefined) {
                    this.tokenizer = i
                }
                j.call(this, g, h)
            }

            e.prototype.bind = function (h, g, i) {
                h.call(this, g, i);
                this.$search = g.dropdown.$search || g.selection.$search || i.find(".select2-search__field")
            };
            e.prototype.query = function (j, k, m) {
                var i = this;

                function h(o) {
                    var n = i._normalizeItem(o);
                    var q = i.$element.find("option").filter(function () {
                        return f(this).val() === n.id
                    });
                    if (!q.length) {
                        var p = i.option(n);
                        p.attr("data-select2-tag", true);
                        i._removeOldTags();
                        i.addOptions([p])
                    }
                    g(n)
                }

                function g(n) {
                    i.trigger("select", {data: n})
                }

                k.term = k.term || "";
                var l = this.tokenizer(k, this.options, h);
                if (l.term !== k.term) {
                    if (this.$search.length) {
                        this.$search.val(l.term);
                        this.$search.focus()
                    }
                    k.term = l.term
                }
                j.call(this, k, m)
            };
            e.prototype.tokenizer = function (o, j, s, r) {
                var k = s.get("tokenSeparators") || [];
                var h = j.term;
                var m = 0;
                var n = this.createTag || function (i) {
                    return {id: i.term, text: i.term}
                };
                while (m < h.length) {
                    var q = h[m];
                    if (f.inArray(q, k) === -1) {
                        m++;
                        continue
                    }
                    var g = h.substr(0, m);
                    var p = f.extend({}, j, {term: g});
                    var l = n(p);
                    if (l == null) {
                        m++;
                        continue
                    }
                    r(l);
                    h = h.substr(m + 1) || "";
                    m = 0
                }
                return {term: h}
            };
            return e
        });
        d.define("select2/data/minimumInputLength", [], function () {
            function e(h, g, f) {
                this.minimumInputLength = f.get("minimumInputLength");
                h.call(this, g, f)
            }

            e.prototype.query = function (f, g, h) {
                g.term = g.term || "";
                if (g.term.length < this.minimumInputLength) {
                    this.trigger("results:message", {
                        message: "inputTooShort",
                        args: {minimum: this.minimumInputLength, input: g.term, params: g}
                    });
                    return
                }
                f.call(this, g, h)
            };
            return e
        });
        d.define("select2/data/maximumInputLength", [], function () {
            function e(h, g, f) {
                this.maximumInputLength = f.get("maximumInputLength");
                h.call(this, g, f)
            }

            e.prototype.query = function (f, g, h) {
                g.term = g.term || "";
                if (this.maximumInputLength > 0 && g.term.length > this.maximumInputLength) {
                    this.trigger("results:message", {
                        message: "inputTooLong",
                        args: {maximum: this.maximumInputLength, input: g.term, params: g}
                    });
                    return
                }
                f.call(this, g, h)
            };
            return e
        });
        d.define("select2/data/maximumSelectionLength", [], function () {
            function e(h, g, f) {
                this.maximumSelectionLength = f.get("maximumSelectionLength");
                h.call(this, g, f)
            }

            e.prototype.query = function (g, h, i) {
                var f = this;
                this.current(function (j) {
                    var k = j != null ? j.length : 0;
                    if (f.maximumSelectionLength > 0 && k >= f.maximumSelectionLength) {
                        f.trigger("results:message", {
                            message: "maximumSelected",
                            args: {maximum: f.maximumSelectionLength}
                        });
                        return
                    }
                    g.call(f, h, i)
                })
            };
            return e
        });
        d.define("select2/dropdown", ["jquery", "./utils"], function (g, f) {
            function e(h, i) {
                this.$element = h;
                this.options = i;
                e.__super__.constructor.call(this)
            }

            f.Extend(e, f.Observable);
            e.prototype.render = function () {
                var h = g('<span class="select2-dropdown"><span class="select2-results"></span></span>');
                h.attr("dir", this.options.get("dir"));
                this.$dropdown = h;
                return h
            };
            e.prototype.bind = function () {
            };
            e.prototype.position = function (h, i) {
            };
            e.prototype.destroy = function () {
                this.$dropdown.remove()
            };
            return e
        });
        d.define("select2/dropdown/search", ["jquery", "../utils"], function (g, f) {
            function e() {
            }

            e.prototype.render = function (i) {
                var j = i.call(this);
                var h = g('<span class="select2-search select2-search--dropdown"><input class="select2-search__field" type="search" tabindex="-1" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" role="textbox" /></span>');
                this.$searchContainer = h;
                this.$search = h.find("input");
                j.prepend(h);
                return j
            };
            e.prototype.bind = function (j, h, k) {
                var i = this;
                j.call(this, h, k);
                this.$search.on("keydown", function (l) {
                    i.trigger("keypress", l);
                    i._keyUpPrevented = l.isDefaultPrevented()
                });
                this.$search.on("input", function (l) {
                    g(this).off("keyup")
                });
                this.$search.on("keyup input", function (l) {
                    i.handleSearch(l)
                });
                h.on("open", function () {
                    i.$search.attr("tabindex", 0);
                    i.$search.focus();
                    window.setTimeout(function () {
                        i.$search.focus()
                    }, 0)
                });
                h.on("close", function () {
                    i.$search.attr("tabindex", -1);
                    i.$search.val("")
                });
                h.on("focus", function () {
                    if (h.isOpen()) {
                        i.$search.focus()
                    }
                });
                h.on("results:all", function (m) {
                    if (m.query.term == null || m.query.term === "") {
                        var l = i.showSearch(m);
                        if (l) {
                            i.$searchContainer.removeClass("select2-search--hide")
                        } else {
                            i.$searchContainer.addClass("select2-search--hide")
                        }
                    }
                })
            };
            e.prototype.handleSearch = function (h) {
                if (!this._keyUpPrevented) {
                    var i = this.$search.val();
                    this.trigger("query", {term: i})
                }
                this._keyUpPrevented = false
            };
            e.prototype.showSearch = function (h, i) {
                return true
            };
            return e
        });
        d.define("select2/dropdown/hidePlaceholder", [], function () {
            function e(h, f, g, i) {
                this.placeholder = this.normalizePlaceholder(g.get("placeholder"));
                h.call(this, f, g, i)
            }

            e.prototype.append = function (g, f) {
                f.results = this.removePlaceholder(f.results);
                g.call(this, f)
            };
            e.prototype.normalizePlaceholder = function (f, g) {
                if (typeof g === "string") {
                    g = {id: "", text: g}
                }
                return g
            };
            e.prototype.removePlaceholder = function (f, i) {
                var h = i.slice(0);
                for (var j = i.length - 1; j >= 0; j--) {
                    var g = i[j];
                    if (this.placeholder.id === g.id) {
                        h.splice(j, 1)
                    }
                }
                return h
            };
            return e
        });
        d.define("select2/dropdown/infiniteScroll", ["jquery"], function (f) {
            function e(i, g, h, j) {
                this.lastParams = {};
                i.call(this, g, h, j);
                this.$loadingMore = this.createLoadingMore();
                this.loading = false
            }

            e.prototype.append = function (h, g) {
                this.$loadingMore.remove();
                this.loading = false;
                h.call(this, g);
                if (this.showLoadingMore(g)) {
                    this.$results.append(this.$loadingMore)
                }
            };
            e.prototype.bind = function (i, g, j) {
                var h = this;
                i.call(this, g, j);
                g.on("query", function (k) {
                    h.lastParams = k;
                    h.loading = true
                });
                g.on("query:append", function (k) {
                    h.lastParams = k;
                    h.loading = true
                });
                this.$results.on("scroll", function () {
                    var m = f.contains(document.documentElement, h.$loadingMore[0]);
                    if (h.loading || !m) {
                        return
                    }
                    var l = h.$results.offset().top + h.$results.outerHeight(false);
                    var k = h.$loadingMore.offset().top + h.$loadingMore.outerHeight(false);
                    if (l + 50 >= k) {
                        h.loadMore()
                    }
                })
            };
            e.prototype.loadMore = function () {
                this.loading = true;
                var g = f.extend({}, {page: 1}, this.lastParams);
                g.page++;
                this.trigger("query:append", g)
            };
            e.prototype.showLoadingMore = function (g, h) {
                return h.pagination && h.pagination.more
            };
            e.prototype.createLoadingMore = function () {
                var h = f('<li class="select2-results__option select2-results__option--load-more"role="treeitem" aria-disabled="true"></li>');
                var g = this.options.get("translations").get("loadingMore");
                h.html(g(this.lastParams));
                return h
            };
            return e
        });
        d.define("select2/dropdown/attachBody", ["jquery", "../utils"], function (g, f) {
            function e(j, h, i) {
                this.$dropdownParent = i.get("dropdownParent") || g(document.body);
                j.call(this, h, i)
            }

            e.prototype.bind = function (k, h, l) {
                var j = this;
                var i = false;
                k.call(this, h, l);
                h.on("open", function () {
                    j._showDropdown();
                    j._attachPositioningHandler(h);
                    if (!i) {
                        i = true;
                        h.on("results:all", function () {
                            j._positionDropdown();
                            j._resizeDropdown()
                        });
                        h.on("results:append", function () {
                            j._positionDropdown();
                            j._resizeDropdown()
                        })
                    }
                });
                h.on("close", function () {
                    j._hideDropdown();
                    j._detachPositioningHandler(h)
                });
                this.$dropdownContainer.on("mousedown", function (m) {
                    m.stopPropagation()
                })
            };
            e.prototype.destroy = function (h) {
                h.call(this);
                this.$dropdownContainer.remove()
            };
            e.prototype.position = function (h, i, j) {
                i.attr("class", j.attr("class"));
                i.removeClass("select2");
                i.addClass("select2-container--open");
                i.css({position: "absolute", top: -999999});
                this.$container = j
            };
            e.prototype.render = function (h) {
                var j = g("<span></span>");
                var i = h.call(this);
                j.append(i);
                this.$dropdownContainer = j;
                return j
            };
            e.prototype._hideDropdown = function (h) {
                this.$dropdownContainer.detach()
            };
            e.prototype._attachPositioningHandler = function (n, h) {
                var i = this;
                var k = "scroll.select2." + h.id;
                var m = "resize.select2." + h.id;
                var l = "orientationchange.select2." + h.id;
                var j = this.$container.parents().filter(f.hasScroll);
                j.each(function () {
                    g(this).data("select2-scroll-position", {x: g(this).scrollLeft(), y: g(this).scrollTop()})
                });
                j.on(k, function (p) {
                    var o = g(this).data("select2-scroll-position");
                    g(this).scrollTop(o.y)
                });
                g(window).on(k + " " + m + " " + l, function (o) {
                    i._positionDropdown();
                    i._resizeDropdown()
                })
            };
            e.prototype._detachPositioningHandler = function (m, h) {
                var j = "scroll.select2." + h.id;
                var l = "resize.select2." + h.id;
                var k = "orientationchange.select2." + h.id;
                var i = this.$container.parents().filter(f.hasScroll);
                i.off(j);
                g(window).off(j + " " + l + " " + k)
            };
            e.prototype._positionDropdown = function () {
                var k = g(window);
                var t = this.$dropdown.hasClass("select2-dropdown--above");
                var j = this.$dropdown.hasClass("select2-dropdown--below");
                var q = null;
                var l = this.$container.offset();
                l.bottom = l.top + this.$container.outerHeight(false);
                var i = {height: this.$container.outerHeight(false)};
                i.top = l.top;
                i.bottom = l.top + i.height;
                var s = {height: this.$dropdown.outerHeight(false)};
                var o = {top: k.scrollTop(), bottom: k.scrollTop() + k.height()};
                var n = o.top < (l.top - s.height);
                var p = o.bottom > (l.bottom + s.height);
                var m = {left: l.left, top: i.bottom};
                var r = this.$dropdownParent;
                if (r.css("position") === "static") {
                    r = r.offsetParent()
                }
                var h = r.offset();
                m.top -= h.top;
                m.left -= h.left;
                if (!t && !j) {
                    q = "below"
                }
                if (!p && n && !t) {
                    q = "above"
                } else {
                    if (!n && p && t) {
                        q = "below"
                    }
                }
                if (q == "above" || (t && q !== "below")) {
                    m.top = i.top - h.top - s.height
                }
                if (q != null) {
                    this.$dropdown.removeClass("select2-dropdown--below select2-dropdown--above").addClass("select2-dropdown--" + q);
                    this.$container.removeClass("select2-container--below select2-container--above").addClass("select2-container--" + q)
                }
                this.$dropdownContainer.css(m)
            };
            e.prototype._resizeDropdown = function () {
                var h = {width: this.$container.outerWidth(false) + "px"};
                if (this.options.get("dropdownAutoWidth")) {
                    h.minWidth = h.width;
                    h.position = "relative";
                    h.width = "auto"
                }
                this.$dropdown.css(h)
            };
            e.prototype._showDropdown = function (h) {
                this.$dropdownContainer.appendTo(this.$dropdownParent);
                this._positionDropdown();
                this._resizeDropdown()
            };
            return e
        });
        d.define("select2/dropdown/minimumResultsForSearch", [], function () {
            function f(i) {
                var h = 0;
                for (var j = 0; j < i.length; j++) {
                    var g = i[j];
                    if (g.children) {
                        h += f(g.children)
                    } else {
                        h++
                    }
                }
                return h
            }

            function e(i, g, h, j) {
                this.minimumResultsForSearch = h.get("minimumResultsForSearch");
                if (this.minimumResultsForSearch < 0) {
                    this.minimumResultsForSearch = Infinity
                }
                i.call(this, g, h, j)
            }

            e.prototype.showSearch = function (g, h) {
                if (f(h.data.results) < this.minimumResultsForSearch) {
                    return false
                }
                return g.call(this, h)
            };
            return e
        });
        d.define("select2/dropdown/selectOnClose", [], function () {
            function e() {
            }

            e.prototype.bind = function (h, f, i) {
                var g = this;
                h.call(this, f, i);
                f.on("close", function (j) {
                    g._handleSelectOnClose(j)
                })
            };
            e.prototype._handleSelectOnClose = function (g, j) {
                if (j && j.originalSelect2Event != null) {
                    var h = j.originalSelect2Event;
                    if (h._type === "select" || h._type === "unselect") {
                        return
                    }
                }
                var f = this.getHighlightedResults();
                if (f.length < 1) {
                    return
                }
                var i = f.data("data");
                if ((i.element != null && i.element.selected) || (i.element == null && i.selected)) {
                    return
                }
                this.trigger("select", {data: i})
            };
            return e
        });
        d.define("select2/dropdown/closeOnSelect", [], function () {
            function e() {
            }

            e.prototype.bind = function (h, f, i) {
                var g = this;
                h.call(this, f, i);
                f.on("select", function (j) {
                    g._selectTriggered(j)
                });
                f.on("unselect", function (j) {
                    g._selectTriggered(j)
                })
            };
            e.prototype._selectTriggered = function (h, g) {
                var f = g.originalEvent;
                if (f && f.ctrlKey) {
                    return
                }
                this.trigger("close", {originalEvent: f, originalSelect2Event: g})
            };
            return e
        });
        d.define("select2/i18n/en", [], function () {
            return {
                errorLoading: function () {
                    return "无法载入结果。"
                }, inputTooLong: function (e) {
                    var g = e.input.length - e.maximum;
                    var f = "请删除 " + g + " 个字符";
                    if (g != 1) {
                        f += "s"
                    }
                    return f
                }, inputTooShort: function (e) {
                    var g = e.minimum - e.input.length;
                    var f = "请再输入至少 " + g + " 个字符";
                    return f
                }, loadingMore: function () {
                    return "加载更多..."
                }, maximumSelected: function (e) {
                    var f = "最多只能选择 " + e.maximum + " 个项目";
                    if (e.maximum != 1) {
                        f += "s"
                    }
                    return f
                }, noResults: function () {
                    return "没有找到匹配项"
                }, searching: function () {
                    return "正在搜索..."
                }
            }
        });
        d.define("select2/defaults", ["jquery", "require", "./results", "./selection/single", "./selection/multiple", "./selection/placeholder", "./selection/allowClear", "./selection/search", "./selection/eventRelay", "./utils", "./translation", "./diacritics", "./data/select", "./data/array", "./data/ajax", "./data/tags", "./data/tokenizer", "./data/minimumInputLength", "./data/maximumInputLength", "./data/maximumSelectionLength", "./dropdown", "./dropdown/search", "./dropdown/hidePlaceholder", "./dropdown/infiniteScroll", "./dropdown/attachBody", "./dropdown/minimumResultsForSearch", "./dropdown/selectOnClose", "./dropdown/closeOnSelect", "./i18n/en"], function (g, k, E, o, t, G, j, C, F, e, u, I, B, s, f, x, h, D, H, w, A, m, q, z, r, v, l, i, y) {
            function p() {
                this.reset()
            }

            p.prototype.apply = function (Z) {
                Z = g.extend(true, {}, this.defaults, Z);
                if (Z.dataAdapter == null) {
                    if (Z.ajax != null) {
                        Z.dataAdapter = f
                    } else {
                        if (Z.data != null) {
                            Z.dataAdapter = s
                        } else {
                            Z.dataAdapter = B
                        }
                    }
                    if (Z.minimumInputLength > 0) {
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, D)
                    }
                    if (Z.maximumInputLength > 0) {
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, H)
                    }
                    if (Z.maximumSelectionLength > 0) {
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, w)
                    }
                    if (Z.tags) {
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, x)
                    }
                    if (Z.tokenSeparators != null || Z.tokenizer != null) {
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, h)
                    }
                    if (Z.query != null) {
                        var R = k(Z.amdBase + "compat/query");
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, R)
                    }
                    if (Z.initSelection != null) {
                        var Y = k(Z.amdBase + "compat/initSelection");
                        Z.dataAdapter = e.Decorate(Z.dataAdapter, Y)
                    }
                }
                if (Z.resultsAdapter == null) {
                    Z.resultsAdapter = E;
                    if (Z.ajax != null) {
                        Z.resultsAdapter = e.Decorate(Z.resultsAdapter, z)
                    }
                    if (Z.placeholder != null) {
                        Z.resultsAdapter = e.Decorate(Z.resultsAdapter, q)
                    }
                    if (Z.selectOnClose) {
                        Z.resultsAdapter = e.Decorate(Z.resultsAdapter, l)
                    }
                }
                if (Z.dropdownAdapter == null) {
                    if (Z.multiple) {
                        Z.dropdownAdapter = A
                    } else {
                        var L = e.Decorate(A, m);
                        Z.dropdownAdapter = L
                    }
                    if (Z.minimumResultsForSearch !== 0) {
                        Z.dropdownAdapter = e.Decorate(Z.dropdownAdapter, v)
                    }
                    if (Z.closeOnSelect) {
                        Z.dropdownAdapter = e.Decorate(Z.dropdownAdapter, i)
                    }
                    if (Z.dropdownCssClass != null || Z.dropdownCss != null || Z.adaptDropdownCssClass != null) {
                        var K = k(Z.amdBase + "compat/dropdownCss");
                        Z.dropdownAdapter = e.Decorate(Z.dropdownAdapter, K)
                    }
                    Z.dropdownAdapter = e.Decorate(Z.dropdownAdapter, r)
                }
                if (Z.selectionAdapter == null) {
                    if (Z.multiple) {
                        Z.selectionAdapter = t
                    } else {
                        Z.selectionAdapter = o
                    }
                    if (Z.placeholder != null) {
                        Z.selectionAdapter = e.Decorate(Z.selectionAdapter, G)
                    }
                    if (Z.allowClear) {
                        Z.selectionAdapter = e.Decorate(Z.selectionAdapter, j)
                    }
                    if (Z.multiple) {
                        Z.selectionAdapter = e.Decorate(Z.selectionAdapter, C)
                    }
                    if (Z.containerCssClass != null || Z.containerCss != null || Z.adaptContainerCssClass != null) {
                        var T = k(Z.amdBase + "compat/containerCss");
                        Z.selectionAdapter = e.Decorate(Z.selectionAdapter, T)
                    }
                    Z.selectionAdapter = e.Decorate(Z.selectionAdapter, F)
                }
                if (typeof Z.language === "string") {
                    if (Z.language.indexOf("-") > 0) {
                        var O = Z.language.split("-");
                        var Q = O[0];
                        Z.language = [Z.language, Q]
                    } else {
                        Z.language = [Z.language]
                    }
                }
                if (g.isArray(Z.language)) {
                    var N = new u();
                    Z.language.push("en");
                    var W = Z.language;
                    for (var M = 0; M < W.length; M++) {
                        var J = W[M];
                        var P = {};
                        try {
                            P = u.loadPath(J)
                        } catch (S) {
                            try {
                                J = this.defaults.amdLanguageBase + J;
                                P = u.loadPath(J)
                            } catch (V) {
                                if (Z.debug && window.console && console.warn) {
                                    console.warn('Select2: The language file for "' + J + '" could not be automatically loaded. A fallback will be used instead.')
                                }
                                continue
                            }
                        }
                        N.extend(P)
                    }
                    Z.translations = N
                } else {
                    var U = u.loadPath(this.defaults.amdLanguageBase + "en");
                    var X = new u(Z.language);
                    X.extend(U);
                    Z.translations = X
                }
                return Z
            };
            p.prototype.reset = function () {
                function K(M) {
                    function L(N) {
                        return I[N] || N
                    }

                    return M.replace(/[^\u0000-\u007E]/g, L)
                }

                function J(Q, P) {
                    if (g.trim(Q.term) === "") {
                        return P
                    }
                    if (P.children && P.children.length > 0) {
                        var L = g.extend(true, {}, P);
                        for (var S = P.children.length - 1; S >= 0; S--) {
                            var R = P.children[S];
                            var O = J(Q, R);
                            if (O == null) {
                                L.children.splice(S, 1)
                            }
                        }
                        if (L.children.length > 0) {
                            return L
                        }
                        return J(Q, L)
                    }
                    var N = K(P.text).toUpperCase();
                    var M = K(Q.term).toUpperCase();
                    if (N.indexOf(M) > -1) {
                        return P
                    }
                    return null
                }

                this.defaults = {
                    amdBase: "./",
                    amdLanguageBase: "./i18n/",
                    closeOnSelect: true,
                    debug: false,
                    dropdownAutoWidth: false,
                    escapeMarkup: e.escapeMarkup,
                    language: y,
                    matcher: J,
                    minimumInputLength: 0,
                    maximumInputLength: 0,
                    maximumSelectionLength: 0,
                    minimumResultsForSearch: 0,
                    selectOnClose: false,
                    sorter: function (L) {
                        return L
                    },
                    templateResult: function (L) {
                        return L.text
                    },
                    templateSelection: function (L) {
                        return L.text
                    },
                    theme: "default",
                    width: "100%"
                }
            };
            p.prototype.set = function (K, M) {
                var J = g.camelCase(K);
                var L = {};
                L[J] = M;
                var N = e._convertData(L);
                g.extend(this.defaults, N)
            };
            var n = new p();
            return n
        });
        d.define("select2/options", ["require", "jquery", "./defaults", "./utils"], function (f, h, i, g) {
            function e(l, j) {
                this.options = l;
                if (j != null) {
                    this.fromElement(j)
                }
                this.options = i.apply(this.options);
                if (j && j.is("input")) {
                    var k = f(this.get("amdBase") + "compat/inputData");
                    this.options.dataAdapter = g.Decorate(this.options.dataAdapter, k)
                }
            }

            e.prototype.fromElement = function (j) {
                var l = ["select2"];
                if (this.options.multiple == null) {
                    this.options.multiple = j.prop("multiple")
                }
                if (this.options.disabled == null) {
                    this.options.disabled = j.prop("disabled")
                }
                if (this.options.language == null) {
                    if (j.prop("lang")) {
                        this.options.language = j.prop("lang").toLowerCase()
                    } else {
                        if (j.closest("[lang]").prop("lang")) {
                            this.options.language = j.closest("[lang]").prop("lang")
                        }
                    }
                }
                if (this.options.dir == null) {
                    if (j.prop("dir")) {
                        this.options.dir = j.prop("dir")
                    } else {
                        if (j.closest("[dir]").prop("dir")) {
                            this.options.dir = j.closest("[dir]").prop("dir")
                        } else {
                            this.options.dir = "ltr"
                        }
                    }
                }
                j.prop("disabled", this.options.disabled);
                j.prop("multiple", this.options.multiple);
                if (j.data("select2Tags")) {
                    if (this.options.debug && window.console && console.warn) {
                        console.warn('Select2: The `data-select2-tags` attribute has been changed to use the `data-data` and `data-tags="true"` attributes and will be removed in future versions of Select2.')
                    }
                    j.data("data", j.data("select2Tags"));
                    j.data("tags", true)
                }
                if (j.data("ajaxUrl")) {
                    if (this.options.debug && window.console && console.warn) {
                        console.warn("Select2: The `data-ajax-url` attribute has been changed to `data-ajax--url` and support for the old attribute will be removed in future versions of Select2.")
                    }
                    j.attr("ajax--url", j.data("ajaxUrl"));
                    j.data("ajax--url", j.data("ajaxUrl"))
                }
                var n = {};
                if (h.fn.jquery && h.fn.jquery.substr(0, 2) == "1." && j[0].dataset) {
                    n = h.extend(true, {}, j[0].dataset, j.data())
                } else {
                    n = j.data()
                }
                var m = h.extend(true, {}, n);
                m = g._convertData(m);
                for (var k in m) {
                    if (h.inArray(k, l) > -1) {
                        continue
                    }
                    if (h.isPlainObject(this.options[k])) {
                        h.extend(this.options[k], m[k])
                    } else {
                        this.options[k] = m[k]
                    }
                }
                return this
            };
            e.prototype.get = function (j) {
                return this.options[j]
            };
            e.prototype.set = function (j, k) {
                this.options[j] = k
            };
            return e
        });
        d.define("select2/core", ["jquery", "./options", "./utils", "./keys"], function (i, g, h, e) {
            var f = function (o, r) {
                if (o.data("select2") != null) {
                    o.data("select2").destroy()
                }
                this.$element = o;
                this.id = this._generateId(o);
                r = r || {};
                this.options = new g(r, o);
                f.__super__.constructor.call(this);
                var m = o.attr("tabindex") || 0;
                o.data("old-tabindex", m);
                o.attr("tabindex", "-1");
                var l = this.options.get("dataAdapter");
                this.dataAdapter = new l(o, this.options);
                var q = this.render();
                this._placeContainer(q);
                var n = this.options.get("selectionAdapter");
                this.selection = new n(o, this.options);
                this.$selection = this.selection.render();
                this.selection.position(this.$selection, q);
                var j = this.options.get("dropdownAdapter");
                this.dropdown = new j(o, this.options);
                this.$dropdown = this.dropdown.render();
                this.dropdown.position(this.$dropdown, q);
                var k = this.options.get("resultsAdapter");
                this.results = new k(o, this.options, this.dataAdapter);
                this.$results = this.results.render();
                this.results.position(this.$results, this.$dropdown);
                var p = this;
                this._bindAdapters();
                this._registerDomEvents();
                this._registerDataEvents();
                this._registerSelectionEvents();
                this._registerDropdownEvents();
                this._registerResultsEvents();
                this._registerEvents();
                this.dataAdapter.current(function (s) {
                    p.trigger("selection:update", {data: s})
                });
                o.addClass("select2-hidden-accessible");
                o.attr("aria-hidden", "true");
                this._syncAttributes();
                o.data("select2", this)
            };
            h.Extend(f, h.Observable);
            f.prototype._generateId = function (j) {
                var k = "";
                if (j.attr("id") != null) {
                    k = j.attr("id")
                } else {
                    if (j.attr("name") != null) {
                        k = j.attr("name") + "-" + h.generateChars(2)
                    } else {
                        k = h.generateChars(4)
                    }
                }
                k = k.replace(/(:|\.|\[|\]|,)/g, "");
                k = "select2-" + k;
                return k
            };
            f.prototype._placeContainer = function (k) {
                k.insertAfter(this.$element);
                var j = this._resolveWidth(this.$element, this.options.get("width"));
                if (j != null) {
                    k.css("width", j)
                }
            };
            f.prototype._resolveWidth = function (u, j) {
                var s = /^width:(([-+]?([0-9]*\.)?[0-9]+)(px|em|ex|%|in|cm|mm|pt|pc))/i;
                if (j == "resolve") {
                    var n = this._resolveWidth(u, "style");
                    if (n != null) {
                        return n
                    }
                    return this._resolveWidth(u, "element")
                }
                if (j == "element") {
                    var r = u.outerWidth(false);
                    if (r <= 0) {
                        return "auto"
                    }
                    return r + "px"
                }
                if (j == "style") {
                    var k = u.attr("style");
                    if (typeof(k) !== "string") {
                        return null
                    }
                    var t = k.split(";");
                    for (var o = 0, m = t.length; o < m; o = o + 1) {
                        var q = t[o].replace(/\s/g, "");
                        var p = q.match(s);
                        if (p !== null && p.length >= 1) {
                            return p[1]
                        }
                    }
                    return null
                }
                return j
            };
            f.prototype._bindAdapters = function () {
                this.dataAdapter.bind(this, this.$container);
                this.selection.bind(this, this.$container);
                this.dropdown.bind(this, this.$container);
                this.results.bind(this, this.$container)
            };
            f.prototype._registerDomEvents = function () {
                var k = this;
                this.$element.on("change.select2", function () {
                    k.dataAdapter.current(function (l) {
                        k.trigger("selection:update", {data: l})
                    })
                });
                this.$element.on("focus.select2", function (l) {
                    k.trigger("focus", l)
                });
                this._syncA = h.bind(this._syncAttributes, this);
                this._syncS = h.bind(this._syncSubtree, this);
                if (this.$element[0].attachEvent) {
                    this.$element[0].attachEvent("onpropertychange", this._syncA)
                }
                var j = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
                if (j != null) {
                    this._observer = new j(function (l) {
                        i.each(l, k._syncA);
                        i.each(l, k._syncS)
                    });
                    this._observer.observe(this.$element[0], {attributes: true, childList: true, subtree: false})
                } else {
                    if (this.$element[0].addEventListener) {
                        this.$element[0].addEventListener("DOMAttrModified", k._syncA, false);
                        this.$element[0].addEventListener("DOMNodeInserted", k._syncS, false);
                        this.$element[0].addEventListener("DOMNodeRemoved", k._syncS, false)
                    }
                }
            };
            f.prototype._registerDataEvents = function () {
                var j = this;
                this.dataAdapter.on("*", function (k, l) {
                    j.trigger(k, l)
                })
            };
            f.prototype._registerSelectionEvents = function () {
                var j = this;
                var k = ["toggle", "focus"];
                this.selection.on("toggle", function () {
                    j.toggleDropdown()
                });
                this.selection.on("focus", function (l) {
                    j.focus(l)
                });
                this.selection.on("*", function (l, m) {
                    if (i.inArray(l, k) !== -1) {
                        return
                    }
                    j.trigger(l, m)
                })
            };
            f.prototype._registerDropdownEvents = function () {
                var j = this;
                this.dropdown.on("*", function (k, l) {
                    j.trigger(k, l)
                })
            };
            f.prototype._registerResultsEvents = function () {
                var j = this;
                this.results.on("*", function (k, l) {
                    j.trigger(k, l)
                })
            };
            f.prototype._registerEvents = function () {
                var j = this;
                this.on("open", function () {
                    j.$container.addClass("select2-container--open")
                });
                this.on("close", function () {
                    j.$container.removeClass("select2-container--open");
                    j.$selection.focus()
                });
                this.on("enable", function () {
                    j.$container.removeClass("select2-container--disabled")
                });
                this.on("disable", function () {
                    j.$container.addClass("select2-container--disabled")
                });
                this.on("blur", function () {
                    j.$container.removeClass("select2-container--focus")
                });
                this.on("query", function (k) {
                    if (!j.isOpen()) {
                        j.trigger("open", {})
                    }
                    this.dataAdapter.query(k, function (l) {
                        j.trigger("results:all", {data: l, query: k})
                    })
                });
                this.on("query:append", function (k) {
                    this.dataAdapter.query(k, function (l) {
                        j.trigger("results:append", {data: l, query: k})
                    })
                });
                this.on("keypress", function (k) {
                    var l = k.which;
                    if (j.isOpen()) {
                        if (l === e.ESC || l === e.TAB || (l === e.UP && k.altKey)) {
                            j.close();
                            k.preventDefault()
                        } else {
                            if (l === e.ENTER) {
                                j.trigger("results:select", {});
                                k.preventDefault()
                            } else {
                                if ((l === e.SPACE && k.ctrlKey)) {
                                    j.trigger("results:toggle", {});
                                    k.preventDefault()
                                } else {
                                    if (l === e.UP) {
                                        j.trigger("results:previous", {});
                                        k.preventDefault()
                                    } else {
                                        if (l === e.DOWN) {
                                            j.trigger("results:next", {});
                                            k.preventDefault()
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (l === e.SPACE || (l === e.DOWN && k.altKey)) {
                            j.open();
                            k.preventDefault()
                        }
                    }
                })
            };
            f.prototype._syncAttributes = function () {
                this.options.set("disabled", this.$element.prop("disabled"));
                if (this.options.get("disabled")) {
                    if (this.isOpen()) {
                        this.close()
                    }
                    this.trigger("disable", {})
                } else {
                    this.trigger("enable", {})
                }
            };
            f.prototype._syncSubtree = function (k, j) {
                var o = false;
                var l = this;
                if (k && k.target && (k.target.nodeName !== "OPTION" && k.target.nodeName !== "OPTGROUP")) {
                    return
                }
                if (!j) {
                    o = true
                } else {
                    if (j.addedNodes && j.addedNodes.length > 0) {
                        for (var p = 0; p < j.addedNodes.length; p++) {
                            var m = j.addedNodes[p];
                            if (m.selected) {
                                o = true
                            }
                        }
                    } else {
                        if (j.removedNodes && j.removedNodes.length > 0) {
                            o = true
                        }
                    }
                }
                if (o) {
                    this.dataAdapter.current(function (n) {
                        l.trigger("selection:update", {data: n})
                    })
                }
            };
            f.prototype.trigger = function (m, l) {
                var n = f.__super__.trigger;
                var o = {open: "opening", close: "closing", select: "selecting", unselect: "unselecting"};
                if (l === undefined) {
                    l = {}
                }
                if (m in o) {
                    var k = o[m];
                    var j = {prevented: false, name: m, args: l};
                    n.call(this, k, j);
                    if (j.prevented) {
                        l.prevented = true;
                        return
                    }
                }
                n.call(this, m, l)
            };
            f.prototype.toggleDropdown = function () {
                if (this.options.get("disabled")) {
                    return
                }
                if (this.isOpen()) {
                    this.close()
                } else {
                    this.open()
                }
            };
            f.prototype.open = function () {
                if (this.isOpen()) {
                    return
                }
                this.trigger("query", {})
            };
            f.prototype.close = function () {
                if (!this.isOpen()) {
                    return
                }
                this.trigger("close", {})
            };
            f.prototype.isOpen = function () {
                return this.$container.hasClass("select2-container--open")
            };
            f.prototype.hasFocus = function () {
                return this.$container.hasClass("select2-container--focus")
            };
            f.prototype.focus = function (j) {
                if (this.hasFocus()) {
                    return
                }
                this.$container.addClass("select2-container--focus");
                this.trigger("focus", {})
            };
            f.prototype.enable = function (j) {
                if (this.options.get("debug") && window.console && console.warn) {
                    console.warn('Select2: The `select2("enable")` method has been deprecated and will be removed in later Select2 versions. Use $element.prop("disabled") instead.')
                }
                if (j == null || j.length === 0) {
                    j = [true]
                }
                var k = !j[0];
                this.$element.prop("disabled", k)
            };
            f.prototype.data = function () {
                if (this.options.get("debug") && arguments.length > 0 && window.console && console.warn) {
                    console.warn('Select2: Data can no longer be set using `select2("data")`. You should consider setting the value instead using `$element.val()`.')
                }
                var j = [];
                this.dataAdapter.current(function (k) {
                    j = k
                });
                return j
            };
            f.prototype.val = function (k) {
                if (this.options.get("debug") && window.console && console.warn) {
                    console.warn('Select2: The `select2("val")` method has been deprecated and will be removed in later Select2 versions. Use $element.val() instead.')
                }
                if (k == null || k.length === 0) {
                    return this.$element.val()
                }
                var j = k[0];
                if (i.isArray(j)) {
                    j = i.map(j, function (l) {
                        return l.toString()
                    })
                }
                this.$element.val(j).trigger("change")
            };
            f.prototype.destroy = function () {
                this.$container.remove();
                if (this.$element[0].detachEvent) {
                    this.$element[0].detachEvent("onpropertychange", this._syncA)
                }
                if (this._observer != null) {
                    this._observer.disconnect();
                    this._observer = null
                } else {
                    if (this.$element[0].removeEventListener) {
                        this.$element[0].removeEventListener("DOMAttrModified", this._syncA, false);
                        this.$element[0].removeEventListener("DOMNodeInserted", this._syncS, false);
                        this.$element[0].removeEventListener("DOMNodeRemoved", this._syncS, false)
                    }
                }
                this._syncA = null;
                this._syncS = null;
                this.$element.off(".select2");
                this.$element.attr("tabindex", this.$element.data("old-tabindex"));
                this.$element.removeClass("select2-hidden-accessible");
                this.$element.attr("aria-hidden", "false");
                this.$element.removeData("select2");
                this.dataAdapter.destroy();
                this.selection.destroy();
                this.dropdown.destroy();
                this.results.destroy();
                this.dataAdapter = null;
                this.selection = null;
                this.dropdown = null;
                this.results = null
            };
            f.prototype.render = function () {
                var j = i('<span class="select2 select2-container"><span class="selection"></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>');
                j.attr("dir", this.options.get("dir"));
                this.$container = j;
                this.$container.addClass("select2-container--" + this.options.get("theme"));
                j.data("element", this.$element);
                return j
            };
            return f
        });
        d.define("jquery-mousewheel", ["jquery"], function (e) {
            return e
        });
        d.define("jquery.select2", ["jquery", "jquery-mousewheel", "./select2/core", "./select2/defaults"], function (h, g, e, i) {
            if (h.fn.select2 == null) {
                var f = ["open", "close", "destroy"];
                h.fn.select2 = function (l) {
                    l = l || {};
                    if (typeof l === "object") {
                        this.each(function () {
                            var n = h.extend(true, {}, l);
                            var m = new e(h(this), n)
                        });
                        return this
                    } else {
                        if (typeof l === "string") {
                            var k;
                            var j = Array.prototype.slice.call(arguments, 1);
                            this.each(function () {
                                var m = h(this).data("select2");
                                if (m == null && window.console && console.error) {
                                    console.error("The select2('" + l + "') method was called on an element that is not using Select2.")
                                }
                                k = m[l].apply(m, j)
                            });
                            if (h.inArray(l, f) > -1) {
                                return this
                            }
                            return k
                        } else {
                            throw new Error("Invalid arguments for Select2: " + l)
                        }
                    }
                }
            }
            if (h.fn.select2.defaults == null) {
                h.fn.select2.defaults = i
            }
            return e
        });
        return {define: d.define, require: d.require}
    }());
    var a = b.require("jquery.select2");
    c.fn.select2.amd = b;
    return a
}));